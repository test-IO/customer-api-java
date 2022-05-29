package testio.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithName;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name implements WithName {

  private String name;

  public static Name name(String name) {
    return new Name(name);
  }
}
