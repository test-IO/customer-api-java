package testio.model.response.entity;

import com.squareup.moshi.Json;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportAttachment implements WithId {

  private Long id;
  private String url;
  @Json(name = "thumbnail_urls")
  private Map<String, String> thumbnailUrls;
}
