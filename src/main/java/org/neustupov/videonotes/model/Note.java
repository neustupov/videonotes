package org.neustupov.videonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties("notes")
  private Sticker sticker;

  @ManyToMany
  private List<Video> videos;

  public Note(String description, Sticker sticker) {
    this.description = description;
    this.sticker = sticker;
  }
}
