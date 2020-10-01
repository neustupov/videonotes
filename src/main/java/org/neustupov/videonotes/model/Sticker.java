package org.neustupov.videonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sticker extends BaseModel{

  private String title;

  @OneToMany
  private List<Note> notes;

  @ManyToMany
  private List<Video> videos;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties("stickers")
  private Board board;
}
