package hello;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class GreetingController {

        private static final String template = "Hola, %s!";
        private final AtomicLong counter = new AtomicLong();
        private EnglishTranslator translator= new EnglishTranslator();

        @RequestMapping("/greeting")
        public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
            return new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
        }

        @RequestMapping("/greeting/english")
        public Greeting greetingEnglish(@RequestParam(value="name", defaultValue="World") String name) {
            String templateEnglish=translator.translateToEnglish(template);
            return new Greeting(counter.incrementAndGet(),
                    String.format(templateEnglish, name));
        }
}
