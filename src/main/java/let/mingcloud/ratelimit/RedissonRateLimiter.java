package let.mingcloud.ratelimit;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author wynn5a
 */
public class RedissonRateLimiter {


  public static void main(String[] args) throws InterruptedException {
    RedissonClient redisson = Redisson.create();
    RRateLimiter limiter = redisson.getRateLimiter("myLimiter");
    // 2 permit per 1 seconds
    limiter.setRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    // 5 permit per 1 seconds
    limiter.setRate(RateType.OVERALL, 5, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    //after all
    printAllKeys(redisson);
    redisson.shutdown();
  }

  private static void printAllKeys(RedissonClient redisson) {
    System.out.println("current keys: ");
    RKeys keys = redisson.getKeys();
    keys.getKeysStream().map(k -> "  " + k).forEach(System.out::println);
  }

  private static void test(RRateLimiter limiter) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(10);
    long start = System.currentTimeMillis();
    System.out.println("Test start @ " + start);
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(() -> {
        Long s = System.currentTimeMillis();
        while (!limiter.tryAcquire(1)) {
          System.out.println(Thread.currentThread().getName() + " has failed");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        System.out.println(Thread.currentThread().getName() + " has acquired, cost: " + (System.currentTimeMillis() - s) / 1000 + " seconds");
        latch.countDown();
      }, "T" + i);
      t.start();
    }

    latch.await();
    System.out.println("All acquire @ " + (System.currentTimeMillis() - start) / 1000 + " seconds");
  }
}
