package testio.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Id implements WithId {

  private Long id;

  public static Id id(Long id) {
    return new Id(id);
  }
}
