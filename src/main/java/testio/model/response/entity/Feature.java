package testio.model.response.entity;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feature implements WithId {

  private Long id;
  private String title;
  private String description;
  private String location;
  private String howtofind;
  @Json(name = "target_idx")
  private String targetIdx;
}
