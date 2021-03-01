package edu.cnm.deepdive.diceware.service;

import java.util.Collection;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleProvider implements WordProvider {

  private final ResourceBundle bundle;

  @Autowired //tells spring to find an instance to use for this constructor
  public BundleProvider(ResourceBundle bundle) {
    this.bundle = bundle;
  }

  @Override
  public Collection<String> words() {//mapping the numbers to the strings
    return bundle //the random words to be generated
        .keySet() //keys are the numbers for the strings(words)
        .parallelStream() //multiple conveyor belts with strings
        .map(bundle::getString) //mapping the strings to they keys(numbers)
        .collect(Collectors.toList());
  }
}
