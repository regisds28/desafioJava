package br.com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class MainServer  {

	public static void main( String[] args )    {
        SpringApplication.run(MainServer.class, args);
    }

}
