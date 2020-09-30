package org.neustupov.videonotes.model;

import java.util.List;
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
public class Sticker extends BaseModel{

  private String title;
  @OneToMany
  private List<Note> notes;
  @ManyToMany
  private List<Video> videos;
  @ManyToOne
  private Board board;
}
