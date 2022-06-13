package testio.model.response;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.UserStory;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class UserStoriesResponse {

  @Json(name = "user_stories")
  List<UserStory> userStories;
}
