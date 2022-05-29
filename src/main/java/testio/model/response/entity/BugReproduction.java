package testio.model.response.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.common.Name;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BugReproduction implements WithId {

  private Long id;
  private DeviceReport device;
  private Boolean positive;
  private Name author;
}
