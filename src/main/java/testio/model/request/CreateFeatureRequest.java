package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFeatureRequest {

  private String title;
  private String description;
  private String howtofind;

  public RequestWrapper buildRequest() {
    return new RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "feature")
    CreateFeatureRequest createFeatureRequest;
  }
}
