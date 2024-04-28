package org.example;

import org.example.client.AccountFeignClient;
import org.example.client.exception.BadRequestException;
import org.example.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class FeignApplication implements CommandLineRunner {

    @Autowired
    private AccountFeignClient accountFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<List<User>> responseEntity = accountFeignClient.getUsers();

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            //Process response body
            List<User> usersList = responseEntity.getBody();
            assert usersList != null;
            usersList.forEach(System.out::println);
        } else if(responseEntity.getStatusCode().is4xxClientError()){
            throw new BadRequestException("Bad Request");
        } else {
            throw new RuntimeException("Server Error");
        }
    }
}