package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.common.Id;
import testio.model.common.IdName;
import testio.model.common.Name;
import testio.model.common.Severity;
import testio.model.common.Status;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bug implements WithId {

  private Long id;
  private String title;
  private Severity severity;
  private Status status;
  private String language;
  private Feature feature;
  private String location;
  @Json(name = "expected_result")
  private String expectedResult;
  @Json(name = "actual_result")
  private String actualResult;
  private Name author;
  private List<BugComment> comments;
  private List<DeviceReport> devices;
  private List<BugReproduction> reproductions;
  @Json(name = "exported_at")
  private OffsetDateTime exportedAt;
  @Json(name = "external_idx")
  private String externalIdx;
  private Boolean known;
  private Product product;
  private IdName section;
  private List<ReportAttachment> attachments;
  private List<String> steps;
  private BugTest test;
  @Json(name = "test_case")
  private Id testCase;
  @Json(name = "test_environment")
  private TestEnvironment testEnvironment;
  @Json(name = "reported_at")
  private OffsetDateTime reportedAt;
}
