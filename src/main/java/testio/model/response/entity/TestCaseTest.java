package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.time.OffsetDateTime;
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
public class TestCaseTest implements WithId {

  private Long id;
  @Json(name = "test_title")
  private String testTitle;
  @Json(name = "test_environment")
  private TestEnvironment testEnvironment;
  @Json(name = "test_case_features")
  private List<TestFeature> testCaseFeatures;
  private String goal;
  @Json(name = "out_of_scope")
  private String outOfScope;
  private String instructions;
  @Json(name = "test_cases")
  private List<TestCase> testCases;
  @Json(name = "test_case_requirements")
  private List<TestScenarioRequirement> testCaseRequirements;
  @Json(name = "report_language")
  private String reportLanguage;
  @Json(name = "start_at")
  private OffsetDateTime startAt;
  @Json(name = "end_at")
  private OffsetDateTime endAt;

}
