package testio.model.common;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestingType {

  @Json(name = "custom")
  CUSTOM,
  @Json(name = "rapid")
  RAPID,
  @Json(name = "usability")
  USABILITY,
  @Json(name = "focused")
  FOCUSED,
  @Json(name = "coverage")
  COVERAGE
}
