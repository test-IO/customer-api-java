package testio.model.response;

import com.squareup.moshi.Json;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import testio.model.response.entity.ExploratoryTest;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ExploratoryTestsResponse {

  @Json(name = "exploratory_tests")
  List<ExploratoryTest> exploratoryTests;
}
