package testio.client;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory;
import testio.model.response.ConnectionResponse;
import testio.utils.OkioUtil;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static testio.client.examples.ConnectionExample.*;

class ConnectionsClientTest {

    MockWebServer server;
    ConnectionsClient connectionsClient;
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
        connectionsClient = factory
                .connectionClient();
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void verifyCreateConnection() throws Exception {
        server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/connectionResponse.json")));

        ConnectionResponse response = connectionsClient.createConnection(CREATE_CONNECTION_REQUEST.buildRequest()).execute().body();

        assertThat(response).isEqualTo(CONNECTION_RESPONSE);

        RecordedRequest recordedRequest = server.takeRequest();
        assertThat(recordedRequest.getRequestLine()).isEqualTo("POST /v2/customer/connections HTTP/1.1");
        assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    }

    @Test
    void verifyFetchConnection() throws Exception {
        server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/connectionResponse.json")));

        ConnectionResponse response = connectionsClient.fetchConnection(123L).execute().body();

        assertThat(response).isEqualTo(CONNECTION_RESPONSE);

        RecordedRequest recordedRequest = server.takeRequest();
        assertThat(recordedRequest.getRequestLine()).isEqualTo("GET /v2/customer/connections/123 HTTP/1.1");
        assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    }

    @Test
    void verifyUpdateConnection() throws Exception {
        server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/connectionResponse.json")));

        ConnectionResponse response = connectionsClient.updateConnection(123L, UPDATE_CONNECTION_REQUEST.buildRequest()).execute().body();

        assertThat(response).isEqualTo(CONNECTION_RESPONSE);

        RecordedRequest recordedRequest = server.takeRequest();
        assertThat(recordedRequest.getRequestLine()).isEqualTo("PUT /v2/customer/connections/123 HTTP/1.1");
        assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    }

    @Test
    void verifyDeleteConnection() throws Exception {
        server.enqueue(new MockResponse().setBody(OkioUtil.resourceToString("/connectionResponse.json")));

        ConnectionResponse response = connectionsClient.deleteConnection(123L).execute().body();

        assertThat(response).isEqualTo(CONNECTION_RESPONSE);

        RecordedRequest recordedRequest = server.takeRequest();
        assertThat(recordedRequest.getRequestLine()).isEqualTo("DELETE /v2/customer/connections/123 HTTP/1.1");
        assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Token abc");
    }
}
