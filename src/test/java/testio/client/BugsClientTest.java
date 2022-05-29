package testio.client;


import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.BugExample.BUGS_RESPONSE;
import static testio.client.examples.BugExample.BUG_RESPONSE;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.request.FilterBugsRequest;
import testio.model.request.FilterBugsRequest.ExportStatus;
import testio.model.request.SearchBugRequest;
import testio.model.response.BugResponse;
import testio.model.response.BugsResponse;
import testio.model.response.RejectReasonsResponse;
import testio.model.response.entity.RejectReason;
import testio.utils.OkioUtil;

class BugsClientTest {

  MockWebServer server;
  BugsClient bugsClient;
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
    bugsClient = factory
        .bugsClient();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  void verifyFetchBugs() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugsResponse.json")));

    BugsResponse response = bugsClient.fetchBugs().execute().body();

    assertThat(response).isEqualTo(BUGS_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("GET /v2/customer/bugs HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyFetchBug() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.fetchBug(8L).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("GET /v2/customer/bugs/8 HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyFilterBugs() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugsResponse.json")));

    FilterBugsRequest request = FilterBugsRequest.builder()
        .query("abc")
        .filterBugIds(Arrays.asList(1L, 2L))
        .filterProductIds(Arrays.asList(3L, 4L))
        .filterSectionIds(Arrays.asList(5L, 6L))
        .filterTestCycleIds(Arrays.asList(7L, 8L))
        .exportStatus(ExportStatus.EXPORTED)
        .build();
    BugsResponse response = bugsClient.fetchBugs(request).execute().body();

    assertThat(response).isEqualTo(BUGS_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo(
        "GET /v2/customer/bugs?filter_test_cycle_ids=7%2C8&export_status=exported&filter_bug_ids=1%2C2&filter_product_ids=3%2C4&query=abc&filter_section_ids=5%2C6 HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifySearchBug() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    SearchBugRequest request = new SearchBugRequest("abcdefg");
    BugResponse response = bugsClient.searchBug(request).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("POST /v2/customer/bugs/search HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    SearchBugRequest actualRequest = factory.getMoshi().adapter(SearchBugRequest.class)
        .fromJson(recordedRequest.getBody());
    assertThat(actualRequest).isEqualTo(request);
  }

  @Test
  void verifyFetchRejectReasons() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/rejectReasonsResponse.json")));

    RejectReasonsResponse response = bugsClient.fetchRejectReasons().execute().body();

    RejectReasonsResponse expectedResponse = RejectReasonsResponse.builder()
        .rejectReasons(Collections.singletonList(
            RejectReason.builder()
                .key("known_bug")
                .name("Known bug")
                .defaultComment("Rejected")
                .build()
        ))
        .build();

    assertThat(response).isEqualTo(expectedResponse);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("GET /v2/customer/bugs/reject_reasons HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyAcceptBug() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.acceptBug(123L).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("PUT /v2/customer/bugs/123/accept HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyMarkAsExported() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.markAsExported(123L).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("PUT /v2/customer/bugs/123/mark_as_exported HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyMarkAsKnown() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.markAsKnown(123L).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("PUT /v2/customer/bugs/123/mark_as_known HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyMarkAsFixed() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.markAsFixed(123L).execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo("PUT /v2/customer/bugs/123/mark_as_fixed HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyRejectBug() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/bugResponse.json")));

    BugResponse response = bugsClient.rejectBug(123L, "duplicate", "Duplicate").execute().body();

    assertThat(response).isEqualTo(BUG_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine()).isEqualTo(
        "PUT /v2/customer/bugs/123/reject?reason=duplicate&comment=Duplicate HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

}
