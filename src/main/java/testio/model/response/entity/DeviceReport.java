package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.util.List;
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
public class DeviceReport implements WithId {

  private Long id;
  private Name category;
  private Name vendor;
  @Json(name = "operating_system")
  private Name operatingSystem;
  @Json(name = "operating_system_version")
  private Name operatingSystemVersion;
  private Name device;
  private List<Name> browsers;

}
