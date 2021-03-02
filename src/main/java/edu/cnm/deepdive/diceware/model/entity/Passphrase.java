package edu.cnm.deepdive.diceware.model.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Passphrase {

  @NonNull
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "passphrase_id", nullable = false, updatable = false)
  private Long id;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @NonNull
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "passphrase",
      cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderBy("order ASC")
  private final List<Word> words = new LinkedList<>();

  @NonNull
  public Long getId() {
    return id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public List<Word> getWords() {
    return words;
  }

}
