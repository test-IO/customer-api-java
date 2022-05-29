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
public class TestScenarioRequirement implements WithId {

  private Long id;
  @Json(name = "test_case_environment_id")
  private Long testCaseEnvironmentId;
  private Requirement requirement;
}
