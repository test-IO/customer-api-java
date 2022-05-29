package testio.model.common;

import com.squareup.moshi.Json;

public enum Severity {
  @Json(name = "low")
  LOW,
  @Json(name = "high")
  HIGH,
  @Json(name = "critical")
  CRITICAL,
  @Json(name = "suggestion")
  SUGGESTION,
  @Json(name = "test_case")
  TEST_CASE,
  @Json(name = "spelling")
  SPELLING,
  @Json(name = "content")
  CONTENT,
  @Json(name = "visual")
  VISUAL
}
