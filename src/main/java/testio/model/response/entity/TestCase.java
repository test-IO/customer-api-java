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
public class TestCase implements WithId {

  private Long id;
  private String title;
  private String requirements;
  @Json(name = "feature_id")
  private Long featureId;
  @Json(name = "target_idx")
  private String targetIdx;
  private List<TestCaseStep> steps;
}
