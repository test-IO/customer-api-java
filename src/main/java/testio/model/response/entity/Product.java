package testio.model.response.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.WithName;
import testio.model.common.IdName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements WithId, WithName {

  private Long id;
  private String name;
  private List<IdName> sections;
}
