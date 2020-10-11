package me.alexthered.contracttesting.producer.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
  
  Integer id;
  String firstName;
  String lastName;
  String email;
}
