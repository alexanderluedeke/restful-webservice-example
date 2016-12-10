package echo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EchoController {

  private static final String template = "Hello, %s!";
  private final AtomicLong globalCounter = new AtomicLong();

  // default is (method=GET)
  @RequestMapping("/echo")
  public Echo echo(@RequestParam(value="name", defaultValue="User") String name) {
    return new Echo(globalCounter.incrementAndGet(),
        String.format(template, name));
  }
}