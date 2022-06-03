package testio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.junit.jupiter.api.Test;
import testio.TestIoClientFactory.Builder;
import testio.internal.AuthInterceptor;

class TestIoClientFactoryTest {

  @Test
  void verifyNewBuilder() {
    TestIoClientFactory factory = new Builder()
        .token("abc")
        .build();

    TestIoClientFactory other = factory.newBuilder()
        .build();

    assertThat(other.getToken()).isEqualTo(factory.getToken());
    assertThat(other.getClient().interceptors()).hasSize(1);
    assertThat(other.getClient().interceptors().get(0)).isInstanceOf(AuthInterceptor.class);
  }

  @Test
  void verifyBuilderDefault() {
    TestIoClientFactory factory = new Builder()
        .token("abc")
        .build();

    assertThat(factory.getLoggingLevel()).isEqualTo(Level.NONE);
    assertThat(factory.getBaseUrl()).isEqualTo(TestIoClientFactory.URL);
  }

  @Test
  void verifyBuilderWithLoggingLevel() {
    TestIoClientFactory factory = new Builder()
        .token("abc")
        .loggingLevel(Level.BODY)
        .build();

    assertThat(factory.getLoggingLevel()).isEqualTo(Level.BODY);
  }

  @Test
  void verifyBuilderWithClient() {
    TestIoClientFactory factory = new Builder()
        .token("abc")
        .client(new OkHttpClient.Builder()
            .build())
        .build();

    assertThat(factory.getClient().interceptors()).hasSize(1);
    assertThat(factory.getClient().interceptors().get(0)).isInstanceOf(AuthInterceptor.class);
  }

  @Test
  void verifyBuilderWithBaseUrl() {
    TestIoClientFactory factory = new Builder()
        .token("abc")
        .baseUrl("https://example.com/")
        .build();

    assertThat(factory.getBaseUrl()).isEqualTo("https://example.com/");
    assertThat(factory.getRetrofit().baseUrl().toString()).isEqualTo("https://example.com/");
  }

  @Test
  void verifyBuilderWithoutToken() {
    assertThatThrownBy(() -> new Builder().build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("Token is required");
  }
}
