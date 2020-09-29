package org.neustupov.videonotes.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video extends BaseModel{

  @ManyToMany
  private List<Note> note;
  @ManyToMany
  private List<Sticker> sticker;
}
