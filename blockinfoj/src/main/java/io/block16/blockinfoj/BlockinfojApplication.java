package io.block16.blockinfoj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.block16"})
public class BlockinfojApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockinfojApplication.class, args);
    }
}
