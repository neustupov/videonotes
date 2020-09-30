package org.neustupov.videonotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Board extends BaseModel {

  private String title;
  @OneToMany(mappedBy = "board",
  cascade = CascadeType.ALL,
  orphanRemoval = true)
  private List<Sticker> stickers;

  public Board() {
    stickers = new ArrayList<>();
  }
}
