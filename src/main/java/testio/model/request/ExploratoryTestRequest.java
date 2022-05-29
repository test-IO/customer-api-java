package testio.model.request;

import com.squareup.moshi.Json;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import testio.model.common.Id;
import testio.model.common.TestingType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExploratoryTestRequest {

  @Json(name = "test_title")
  private String testTitle;
  @Json(name = "test_template")
  private Id testTemplate;
  private String goal;
  @Json(name = "out_of_scope")
  private String outOfScope;
  private String instructions;
  @Json(name = "start_at")
  private OffsetDateTime startAt;
  private String duration;
  @Json(name = "report_language")
  private String reportLanguage;
  @Json(name = "testing_type")
  private TestingType testingType;
  @Json(name = "section_id")
  private Long sectionId;
  private List<Id> requirements;
  @Json(name = "test_environment")
  private Id testEnvironment;
  private List<Id> features;
  private List<Attachment> attachments;

  public RequestWrapper buildRequest() {
    return new RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "exploratory_test")
    ExploratoryTestRequest exploratoryTest;
  }
}
