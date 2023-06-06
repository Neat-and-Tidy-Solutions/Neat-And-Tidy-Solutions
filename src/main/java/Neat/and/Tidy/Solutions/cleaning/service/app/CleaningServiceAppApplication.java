package Neat.and.Tidy.Solutions.cleaning.service.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CleaningServiceAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(CleaningServiceAppApplication.class, args);
	}
	@GetMapping("cleaning-service-app")
	public String getCleaningApp(){
		return "This is a cleaning service app";
	}
}
