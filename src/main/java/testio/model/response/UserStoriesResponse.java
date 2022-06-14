package testio.model.response;

import com.squareup.moshi.Json;
import java.util.List;
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
public class UserStoriesResponse {

  @Json(name = "user_stories")
  List<UserStory> userStories;
}
