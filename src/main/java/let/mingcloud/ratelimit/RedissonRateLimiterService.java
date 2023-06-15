package let.mingcloud.ratelimit;

import org.redisson.api.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @author wynn5a
 */
@Service
public class RedissonRateLimiterService {
  private final RedissonClient redisson;

  public RedissonRateLimiterService(RedissonClient redissonClient) {
    this.redisson = redissonClient;
  }

  public void test() throws InterruptedException {
    RRateLimiter limiter = redisson.getRateLimiter("myLimiter");
    System.out.println("\nTest -- 2 permit per 1 seconds");
    limiter.setRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    System.out.println("\nTest -- 5 permit per 1 seconds");
    limiter.setRate(RateType.OVERALL, 5, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    System.out.println("\nTest -- 100 permit per 1 seconds");
    limiter.setRate(RateType.OVERALL, 100, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    System.out.println("\nTest -- 200 permit per 1 seconds");
    limiter.setRate(RateType.OVERALL, 200, 1, RateIntervalUnit.SECONDS);
    printAllKeys(redisson);
    test(limiter);

    //after all
    printAllKeys(redisson);
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
