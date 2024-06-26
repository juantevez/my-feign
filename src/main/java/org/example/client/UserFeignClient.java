package org.example.client;

import org.example.dto.User;;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "userFeignClient", url = "https://jsonplaceholder.typicode.com/")
public interface UserFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/users")
  ResponseEntity<List<User>> getUsers();
}
