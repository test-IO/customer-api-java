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
public class TestCaseStep implements WithId {

  private Long id;
  private String description;
  @Json(name = "test_case_id")
  private Long testCaseId;
  @Json(name = "target_idx")
  private String targetIdx;

}
