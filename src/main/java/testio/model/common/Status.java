package testio.model.common;

import com.squareup.moshi.Json;

public enum Status {
  @Json(name = "submitted")
  SUBMITTED,
  @Json(name = "manager_approved")
  MANAGER_APPROVED,
  @Json(name = "forwarded")
  FORWARDED,
  @Json(name = "question")
  QUESTION,
  @Json(name = "accepted")
  ACCEPTED,
  @Json(name = "rejected")
  REJECTED
}
