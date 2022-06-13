package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnectionRequest {

  private Long id;
  private String name;
  private String url;
  private boolean fixed;

  @Json(name = "product_ids")
  private List<Long> productIds;

  @Json(name = "section_ids")
  private List<Long> sectionIds;

  public CreateConnectionRequest.RequestWrapper buildRequest() {
    return new CreateConnectionRequest.RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "connection")
    CreateConnectionRequest createConnectionRequest;
  }
}
