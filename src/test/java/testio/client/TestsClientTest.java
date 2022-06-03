package testio.client;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.ExploratoryTestRequestExample.EXPLORATORY_TEST_REQUEST;
import static testio.client.examples.ExploratoryTestResponseExample.EXPLORATORY_TESTS_RESPONSE;
import static testio.client.examples.ExploratoryTestResponseExample.EXPLORATORY_TEST_RESPONSE;
import static testio.client.examples.TestCaseTestRequestExample.TEST_CASE_TEST_REQUEST;
import static testio.client.examples.TestCaseTestResponseExample.TEST_CASE_TEST_RESPONSE;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.request.ExploratoryTestRequest;
import testio.model.request.TestCaseTestRequest;
import testio.model.response.ExploratoryTestResponse;
import testio.model.response.ExploratoryTestsResponse;
import testio.model.response.TestCaseTestResponse;
import testio.utils.OkioUtil;

class TestsClientTest {

  MockWebServer server;
  TestsClient testsClient;
  TestIoClientFactory factory;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();

    HttpUrl baseUrl = server.url("/v2/customer/");

    factory = new TestIoClientFactory.Builder()
        .baseUrl(baseUrl.toString())
        .token("abc")
        .build();
    testsClient = factory
        .testsClient();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  void verifyFetchExploratoryTests() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/exploratoryTestsResponse.json")));

    ExploratoryTestsResponse response = testsClient.fetchExploratoryTests(123L).execute().body();

    assertThat(response).isEqualTo(EXPLORATORY_TESTS_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("GET /v2/customer/products/123/exploratory_tests HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyCreateExploratoryTest() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/exploratoryTestResponse.json")));

    ExploratoryTestResponse response = testsClient.createExploratoryTest(123L, EXPLORATORY_TEST_REQUEST.buildRequest())
        .execute()
        .body();

    assertThat(response).isEqualTo(EXPLORATORY_TEST_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("POST /v2/customer/products/123/exploratory_tests HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    ExploratoryTestRequest.RequestWrapper actualRequest = factory.getMoshi()
        .adapter(ExploratoryTestRequest.RequestWrapper.class)
        .fromJson(recordedRequest.getBody());
    assertThat(actualRequest).isEqualTo(EXPLORATORY_TEST_REQUEST.buildRequest());
  }

  @Test
  void verifyCreateTestCaseTest() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/testCaseTestResponse.json")));

    TestCaseTestResponse response = testsClient.createTestCaseTest(123L, TEST_CASE_TEST_REQUEST.buildRequest())
        .execute().body();

    assertThat(response).isEqualTo(TEST_CASE_TEST_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("POST /v2/customer/products/123/test_case_test HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    TestCaseTestRequest.RequestWrapper actualRequest = factory.getMoshi().adapter(
            TestCaseTestRequest.RequestWrapper.class)
        .fromJson(recordedRequest.getBody());
    assertThat(actualRequest).isEqualTo(TEST_CASE_TEST_REQUEST.buildRequest());
  }
}
