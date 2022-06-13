package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserStoryRequest {

  private String path;

  @Json(name = "feature_id")
  private Long featureId;

  public RequestWrapper buildRequest() {
    return new RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "user_story")
    CreateUserStoryRequest createUserStoryRequest;
  }
}
