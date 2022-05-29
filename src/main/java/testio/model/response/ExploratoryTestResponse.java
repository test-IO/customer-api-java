package testio.model.response;

import com.squareup.moshi.Json;
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
public class ExploratoryTestResponse {

  @Json(name = "exploratory_test")
  ExploratoryTest exploratoryTest;
}
