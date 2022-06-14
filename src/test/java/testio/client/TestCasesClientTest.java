package testio.client;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.TestCaseExample.BULK_TEST_CASE_REQUEST;
import static testio.client.examples.TestCaseExample.TEST_CASES_RESPONSE;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.response.TestCasesResponse;
import testio.utils.OkioUtil;

public class TestCasesClientTest {

  MockWebServer server;
  TestCasesClient testCasesClient;
  TestIoClientFactory factory;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();

    HttpUrl baseUrl = server.url("/v2/customer/");

    factory = new TestIoClientFactory.Builder().baseUrl(baseUrl.toString()).token("abc").build();
    testCasesClient = factory.testCasesClient();
  }

  @AfterEach
  void tearDown() throws Exception {
    server.shutdown();
  }

  @Test
  void verifyCreateUserStory() throws Exception {
    server.enqueue(
        new MockResponse().setBody(OkioUtil.resourceToString("/testCasesResponse.json")));

    TestCasesResponse response =
        testCasesClient.createTestCases(1L, BULK_TEST_CASE_REQUEST).execute().body();

    assertThat(response).isEqualTo(TEST_CASES_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("POST /v2/customer/products/1/test_cases HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }
}
