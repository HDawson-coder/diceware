package edu.cnm.deepdive.diceware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Word {

  @NonNull
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "word_id", nullable = false, updatable = false)
  private Long id;

  @JsonIgnore
  @NonNull
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "passphrase_id")
  private Passphrase passphrase;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String content;

  @Column(name="position", updatable = false)
  private int order;

  @NonNull
  public Long getId() {
    return id;
  }

  @NonNull
  public Passphrase getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(@NonNull Passphrase passphrase) {
    this.passphrase = passphrase;
  }

  @NonNull
  public String getContent() {
    return content;
  }

  public void setContent(@NonNull String content) {
    this.content = content;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

}
