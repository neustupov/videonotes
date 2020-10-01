package org.neustupov.videonotes.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Note extends BaseModel{

  private String description;

  @ManyToOne
  private User user;

  @ManyToMany
  private List<Video> videos;

  public Note(String description) {
    this.description = description;
  }
}
