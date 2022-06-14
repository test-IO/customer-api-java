package testio.client;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.FeatureExample.CREATE_FEATURE_REQUEST;
import static testio.client.examples.FeatureExample.FEATURES_RESPONSE;
import static testio.client.examples.FeatureExample.FEATURE_RESPONSE;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.response.FeatureResponse;
import testio.model.response.FeaturesResponse;
import testio.utils.OkioUtil;

public class FeaturesClientTest {

  MockWebServer server;
  FeaturesClient featuresClient;
  TestIoClientFactory factory;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();

    HttpUrl baseUrl = server.url("/v2/customer/");

    factory = new TestIoClientFactory.Builder().baseUrl(baseUrl.toString()).token("abc").build();
    featuresClient = factory.featuresClient();
  }

  @AfterEach
  void tearDown() throws Exception {
    server.shutdown();
  }

  @Test
  void verifyListFeatures() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/featuresResponse.json")));

    FeaturesResponse response = featuresClient.listFeatures(1L).execute().body();

    assertThat(response).isEqualTo(FEATURES_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("GET /v2/customer/products/1/features HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }

  @Test
  void verifyCreateFeature() throws Exception {
    server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/featureResponse.json")));

    FeatureResponse response =
        featuresClient.createFeature(1L, CREATE_FEATURE_REQUEST.buildRequest()).execute().body();

    assertThat(response).isEqualTo(FEATURE_RESPONSE);

    RecordedRequest recordedRequest = server.takeRequest();
    assertThat(recordedRequest.getRequestLine())
        .isEqualTo("POST /v2/customer/products/1/features HTTP/1.1");
    assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
  }
}
