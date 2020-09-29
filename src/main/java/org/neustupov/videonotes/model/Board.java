package org.neustupov.videonotes.model;

import java.util.List;
import javax.persistence.Entity;
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
public class Board extends BaseModel {

  private String name;
  @OneToMany
  private List<Sticker> stickers;
}
