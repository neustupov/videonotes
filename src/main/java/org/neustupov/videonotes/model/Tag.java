package org.neustupov.videonotes.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag extends BaseModel{

  private String name;
  @ManyToMany
  private Set<Note> notes;
}
