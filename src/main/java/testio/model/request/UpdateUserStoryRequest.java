package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserStoryRequest {

  private String path;

  public RequestWrapper buildRequest() {
    return new RequestWrapper(this);
  }

  @Value
  @AllArgsConstructor(access = AccessLevel.PACKAGE)
  public static class RequestWrapper {

    @Json(name = "user_story")
    UpdateUserStoryRequest createUserStoryRequest;
  }
}
