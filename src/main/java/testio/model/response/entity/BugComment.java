package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;
import testio.model.common.Name;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BugComment implements WithId {

  private Long id;
  private Name author;
  private String body;
  @Json(name = "created_at")
  private OffsetDateTime createdAt;
}
