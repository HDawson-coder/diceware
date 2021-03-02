package edu.cnm.deepdive.diceware.model.dao;

import edu.cnm.deepdive.diceware.model.entity.Passphrase;
import org.springframework.data.repository.CrudRepository;

public interface PassphraseRepository extends CrudRepository<Passphrase, Long> {

}
