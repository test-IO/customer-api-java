package testio.client.examples;

import static java.util.Collections.singletonList;

import testio.model.request.CreateUserStoryRequest;
import testio.model.request.UpdateUserStoryRequest;
import testio.model.response.UserStoriesResponse;
import testio.model.response.UserStoryResponse;
import testio.model.response.entity.UserStory;

public final class UserStoryExample {

  public static final UserStory USER_STORY =
      UserStory.builder().id(1L).path("path of the user story").build();

  public static final UserStoriesResponse USER_STORIES_RESPONSE =
      UserStoriesResponse.builder().userStories(singletonList(USER_STORY)).build();

  public static final UserStoryResponse USER_STORY_RESPONSE =
      UserStoryResponse.builder().userStory(USER_STORY).build();

  public static final CreateUserStoryRequest CREATE_USER_STORY_REQUEST =
      CreateUserStoryRequest.builder().path("path of the user story").featureId(1L).build();

  public static final UpdateUserStoryRequest UPDATE_USER_STORY_REQUEST =
      UpdateUserStoryRequest.builder().path("path of the user story").build();
}
