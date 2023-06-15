package let.mingcloud.ratelimit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wynn5a
 */
@RestController
public class Controller {
  final RedissonRateLimiterService service;

  public Controller(RedissonRateLimiterService service) {
    this.service = service;
  }


  @GetMapping("test")
  public String test() throws InterruptedException {
    service.test();
    return "success";
  }
}
