package org.neustupov.videonotes.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"User\"")
public class User extends BaseModel{

  private String name;

  @OneToMany
  private List<Note> notes;
}
