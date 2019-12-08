package annotationmanager.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"annotationmanager.annotation","annotationmanager.config",
        "annotationmanager.entity","annotationmanager.listener","annotationmanager.service",
"annotationmanager.util"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
