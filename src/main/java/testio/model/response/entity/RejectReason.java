package testio.model.response.entity;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RejectReason implements WithName {

  private String key;
  private String name;
  @Json(name = "default_comment")
  private String defaultComment;
}
