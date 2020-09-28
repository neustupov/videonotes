package org.neustupov.videonotes.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video extends BaseModel{

  @ManyToOne
  private Note note;
}
