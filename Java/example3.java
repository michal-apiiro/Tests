package com.myproject.test_app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TestAppApplication {
public static void main(String[] args) {
SpringApplication.run(TestAppApplication.class, args);
}
@GetMapping("/greeting")
public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
return String.format("<h1>Hello %s!, This is My First Spring Project</h1>", name);
}
}