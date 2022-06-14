package testio.model.request;

import com.squareup.moshi.Json;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCasesRequest {

  @Json(name = "test_cases")
  List<TestCaseRequest> testCaseRequests;
}
