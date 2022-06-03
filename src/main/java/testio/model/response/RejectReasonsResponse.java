package testio.model.response;

import com.squareup.moshi.Json;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import testio.model.response.entity.RejectReason;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class RejectReasonsResponse {

  @Json(name = "reject_reasons")
  List<RejectReason> rejectReasons;
}
