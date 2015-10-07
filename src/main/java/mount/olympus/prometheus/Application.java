package mount.olympus.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // this annotation is equivalent to these 3:
						// @Configuration, @EnableAutoConfiguration,
						// @ComponentScan

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan

@RestController
// @ComponentScan(basePackages="mount.olympus.prometheus.**")
@ImportResource({ "classpath*:applicationContext.xml" }) // use XML
															// configuration
public class Application {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
