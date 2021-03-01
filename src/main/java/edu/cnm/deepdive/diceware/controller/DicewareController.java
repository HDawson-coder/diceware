package edu.cnm.deepdive.diceware.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DicewareController {

  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public String helloWorld(
      @RequestParam(required = false, defaultValue = "world") String name) {
    return String.format("Hello, %s!", name);
  }

}
