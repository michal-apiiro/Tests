package java.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class Class1 {

    @Value("$ervers}")
    private String server;

    @Value("${url}")
    private String url;

}