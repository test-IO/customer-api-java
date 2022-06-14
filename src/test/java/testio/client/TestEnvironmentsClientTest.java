package testio.client;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.TestEnvironmentExample.TEST_ENVIRONMENTS_RESPONSE;
import static testio.client.examples.TestEnvironmentExample.TEST_ENVIRONMENT_REQUEST;
import static testio.client.examples.TestEnvironmentExample.TEST_ENVIRONMENT_RESPONSE;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.response.TestEnvironmentResponse;
import testio.model.response.TestEnvironmentsResponse;
import testio.utils.OkioUtil;

public class TestEnvironmentsClientTest {

  MockWebServer server;
  TestEnvironmentsClient testEnvironmentsClient;
  TestIoClientFactory factory;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();

    HttpUrl baseUrl = server.url("/v2/customer/");

    factory = new TestIoClientFactory.Builder().baseUrl(baseUrl.toString()).token("abc").build();
    testEnvironmentsClient = factory.testEnvironmentsClient();
  }

  @AfterEach
  void tearDown() throws Exception {
    server.shutdown();
  }

  @Test
  void verifyListTestEnvironments() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/testEnvironmentsResponse.json")));

    TestEnvironmentsResponse response =
        testEnvironmentsClient.listTestEnvironments(1L).execute().body();

    assertThat(response).isEqualTo(TEST_ENVIRONMENTS_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("GET /v2/customer/products/1/test_environments HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyCreateTestEnvironments() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/testEnvironmentResponse.json")));

    TestEnvironmentResponse response =
        testEnvironmentsClient
            .createTestEnvironment(1L, TEST_ENVIRONMENT_REQUEST.buildRequest())
            .execute()
            .body();

    assertThat(response).isEqualTo(TEST_ENVIRONMENT_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("POST /v2/customer/products/1/test_environments HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyDeleteUserStory() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/testEnvironmentResponse.json")));

    TestEnvironmentResponse response =
        testEnvironmentsClient.deleteTestEnvironment(1L, 37L).execute().body();

    assertThat(response).isEqualTo(TEST_ENVIRONMENT_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("DELETE /v2/customer/products/1/test_environments/37 HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }
}
