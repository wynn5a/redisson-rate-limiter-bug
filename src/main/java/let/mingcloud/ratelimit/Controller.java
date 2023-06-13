package let.mingcloud.ratelimit;

import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wynn5a
 */
@RestController
public class Controller {
  final static RRateLimiter limiter;

  static {
    final RedissonClient redisson = Redisson.create();
    limiter = redisson.getRateLimiter("myLimiter");
    limiter.setRate(RateType.OVERALL, 5, 1, RateIntervalUnit.SECONDS);
  }

  @GetMapping("test")
  public String get() {
    limiter.acquire(1);
    return "success";
  }
}
