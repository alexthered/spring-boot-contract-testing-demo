package me.alexthered.contracttesting.consumer.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class HelloController {
  
  public static final String FIRST_NAME = "firstName";
  private final RestTemplate restTemplate;
  
  @Value("${producer.url}")
  private String producerUrl;
  
  public HelloController() {
    this.restTemplate = new RestTemplateBuilder()
        .build();
  }
  
  @GetMapping("/hello/{userId}")
  public String helloUser(@PathVariable Integer userId) {
    return "Hello " + getUserFirstName(userId);
  }
  
  private String getUserFirstName(Integer userId) {
    Map<String, String> responseEntity = restTemplate.getForObject(
        producerUrl + "/users/{userId}",
        Map.class,
        userId);
  
    return responseEntity.get(FIRST_NAME);
  }
}
