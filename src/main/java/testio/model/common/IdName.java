package testio.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.WithName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdName implements WithId, WithName {

  private Long id;
  private String name;

  public static IdName idName(Long id, String name) {
    return new IdName(id, name);
  }
}
