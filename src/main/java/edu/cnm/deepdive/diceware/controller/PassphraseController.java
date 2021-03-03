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
@RequestMapping("/passphrases")
public class PassphraseController {

  private final PassphraseGenerator generator;
  private final PassphraseRepository repository;

  @Autowired
  public PassphraseController(PassphraseGenerator generator,
      PassphraseRepository repository) {
    this.generator = generator;
    this.repository = repository;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Passphrase post(@RequestParam(required = false, defaultValue = "4") int length) {
    Passphrase passphrase = new Passphrase();
    String[] words = generator.generate(length);
    for (String content : words) {
      Word word = new Word();
      word.setContent(content);
      word.setPassphrase(passphrase);
      word.setOrder(passphrase.getWords().size());
      passphrase.getWords().add(word);
    }
    return repository.save(passphrase);
  }

  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Passphrase getPassphrase(@PathVariable long id) {
    return repository
        .findById(id)
        .orElseThrow();
  }

}
