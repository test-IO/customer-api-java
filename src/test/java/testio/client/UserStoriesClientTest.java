package testio.client;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.response.UserStoriesResponse;
import testio.model.response.UserStoryResponse;
import testio.utils.OkioUtil;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.UserStoryExample.*;

public class UserStoriesClientTest {

  MockWebServer server;
  UserStoriesClient userStoriesClient;
  TestIoClientFactory factory;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();

    HttpUrl baseUrl = server.url("/v2/customer/");

    factory = new TestIoClientFactory.Builder().baseUrl(baseUrl.toString()).token("abc").build();
    userStoriesClient = factory.userStoriesClient();
  }

  @AfterEach
  void tearDown() throws Exception {
    server.shutdown();
  }

  @Test
  void verifyListUserStories() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/userStoriesResponse.json")));

    UserStoriesResponse response = userStoriesClient.listUserStories(1L).execute().body();

    assertThat(response).isEqualTo(USER_STORIES_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("GET /v2/customer/products/1/user_stories HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyCreateUserStory() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/userStoryResponse.json")));

    UserStoryResponse response =
        userStoriesClient
            .createUserStory(1L, CREATE_USER_STORY_REQUEST.buildRequest())
            .execute()
            .body();

    assertThat(response).isEqualTo(USER_STORY_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("POST /v2/customer/products/1/user_stories HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyDeleteUserStory() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/userStoryResponse.json")));

    UserStoryResponse response = userStoriesClient.deleteUserStory(1L, 1L).execute().body();

    assertThat(response).isEqualTo(USER_STORY_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("DELETE /v2/customer/products/1/user_stories/1 HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyUpdateUserStory() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/userStoryResponse.json")));

    UserStoryResponse response =
        userStoriesClient
            .updateUserStory(1L, 1L, UPDATE_USER_STORY_REQUEST.buildRequest())
            .execute()
            .body();

    assertThat(response).isEqualTo(USER_STORY_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("PUT /v2/customer/products/1/user_stories/1 HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }
}
