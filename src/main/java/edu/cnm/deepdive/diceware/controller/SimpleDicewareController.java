package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.model.dao.PassphraseRepository;
import edu.cnm.deepdive.diceware.model.entity.Passphrase;
import edu.cnm.deepdive.diceware.model.entity.Word;
import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceware")
public class SimpleDicewareController {

  private final PassphraseGenerator generator;

  @Autowired
  public SimpleDicewareController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] get(@RequestParam(required = false, defaultValue = "4") int length) {
    return generator.generate(length);
  }

}
