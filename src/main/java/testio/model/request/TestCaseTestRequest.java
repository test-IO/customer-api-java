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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseTestRequest {

  @Json(name = "test_title")
  private String testTitle;

  private String goal;

  @Json(name = "out_of_scope")
  private String outOfScope;

  private String instructions;

  @Json(name = "start_at")
  private OffsetDateTime startAt;

  private String duration;

  @Json(name = "report_language")
  private String reportLanguage;

  @Json(name = "test_cases")
  private List<Id> testCases;

  private List<Id> requirements;

  @Json(name = "test_environment")
  private Id testEnvironment;

  public RequestWrapper buildRequest() {
    return new RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "test_case_test")
    TestCaseTestRequest testCaseTest;
  }
}
