package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.common.IdName;
import testio.model.common.TestingType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExploratoryTest implements WithId {

  private Long id;
  @Json(name = "test_title")
  private String testTitle;
  private String title;
  @Json(name = "test_environment")
  private TestEnvironment testEnvironment;
  private List<TestFeature> features;
  private String goal;
  @Json(name = "out_of_scope")
  private String outOfScope;
  private String instructions;
  @Json(name = "testing_type")
  private TestingType testingType;
  private List<Requirement> requirements;
  @Json(name = "report_language")
  private String reportLanguage;
  private IdName section;
  private Product product;
  @Json(name = "start_at")
  private OffsetDateTime startAt;
  @Json(name = "end_at")
  private OffsetDateTime endAt;
}
