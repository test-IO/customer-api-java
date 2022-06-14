package testio.model.response;

import com.squareup.moshi.Json;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import testio.model.response.entity.UserStory;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class UserStoryResponse {

  @Json(name = "user_story")
  UserStory userStory;
}
