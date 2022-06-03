package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.common.IdName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Requirement implements WithId {

  private Long id;
  private List<IdName> browsers;
  private IdName category;
  private List<IdName> devices;
  @Json(name = "input_devices")
  private List<IdName> inputDevices;
  @Json(name = "max_operating_system_version")
  private IdName maxOperatingSystemVersion;
  @Json(name = "min_operating_system_version")
  private IdName minOperatingSystemVersion;
  @Json(name = "operating_system")
  private IdName operatingSystem;
  private IdName vendor;
}
