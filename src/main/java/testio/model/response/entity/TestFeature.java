package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestFeature implements WithId {

  private Long id;
  @Json(name = "feature_id")
  private Long featureId;
  private String title;
  private String description;
  private String location;
  private String howtofind;
  @Json(name = "target_idx")
  private String targetIdx;
  @Json(name = "enable_default")
  private Boolean enableDefault;
  @Json(name = "enable_content")
  private Boolean enableContent;
  @Json(name = "user_stories")
  private List<String> userStories;
}
