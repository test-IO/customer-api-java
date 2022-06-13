package testio.model.response;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.UserStory;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class UserStoryResponse {

  @Json(name = "user_story")
  UserStory userStory;
}
