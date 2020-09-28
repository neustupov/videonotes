package org.neustupov.videonotes.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Note extends BaseModel{

  public Note(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  private String name;
  private String desc;
  @ManyToOne
  private User user;
  @OneToMany
  private Set<Video> videos;
  @ManyToMany
  private Set<Tag> tags;
}
