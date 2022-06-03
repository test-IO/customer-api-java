package testio;

import com.squareup.moshi.Moshi;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import testio.client.BugsClient;
import testio.client.TestsClient;
import testio.internal.AuthInterceptor;
import testio.internal.OffsetDateTimeAdapter;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TestIoClientFactory {

  public static final String URL = "https://api.test.io/customer/v2/";

  private final Moshi moshi;
  private final Retrofit retrofit;
  private final String baseUrl;
  private final String token;
  private final OkHttpClient client;
  private final Level loggingLevel;

  public Builder newBuilder() {
    return new Builder(this);
  }

  public BugsClient bugsClient() {
    return retrofit.create(BugsClient.class);
  }

  public TestsClient testsClient() {
    return retrofit.create(TestsClient.class);
  }

  /**
   * Builder for {@link TestIoClientFactory}
   */
  @SuppressWarnings("JavadocLinkAsPlainText")
  @NoArgsConstructor
  public static final class Builder {

    private String baseUrl;
    private String token;
    private OkHttpClient client;
    private Level loggingLevel = Level.NONE;

    Builder(TestIoClientFactory factory) {
      this.baseUrl = factory.baseUrl;
      this.token = factory.token;
      this.client = (OkHttpClient) factory.retrofit.callFactory();
      this.loggingLevel = factory.loggingLevel;
    }

    /**
     * Set the API base URL.
     *
     * <p><b>Base URLs should always end in {@code /}.</b>
     *
     * <p><b>Correct:</b><br>
     * Base URL: http://example.com/api/<br>
     *
     * <p><b>Incorrect:</b><br>
     * Base URL: http://example.com/api<br>
     *
     * <p>In case if baseUrl is not set, default value of
     * <a href="https://api.test.io/customer/v2/">https://api.test.io/customer/v2/</a> will be used</p>
     *
     * @param baseUrl API base URL
     * @return current {@link Builder}
     */
    public Builder baseUrl(@NonNull String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    /**
     * Set Authorization Token.
     *
     * <p>Used for setting Authorization header.</p>
     *
     * <p>API token can be obtained from the settings page of your test IO account.</p>
     *
     * <p><b>Example:</b><br>
     * <b>Authorization: </b> Token {@code <<token>>}</p>
     *
     * @param token Auth token
     * @return current {@link Builder}
     */
    public Builder token(@NonNull String token) {
      this.token = token;
      return this;
    }

    /**
     * The HTTP client used for requests.
     *
     * @param client {@link OkHttpClient} see <a href="https://square.github.io/okhttp/">Docs</a>
     * @return current {@link Builder}
     */
    public Builder client(@NonNull OkHttpClient client) {
      this.client = client;
      return this;
    }

    /**
     * Sets Request/Response logging level.
     *
     * @param loggingLevel {@link Level} see <a
     * href="https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor">Docs</a>
     * @return current {@link Builder}
     */
    public Builder loggingLevel(@NonNull Level loggingLevel) {
      this.loggingLevel = loggingLevel;
      return this;
    }

    /**
     * Create the {@link TestIoClientFactory} instance using the configured values.
     *
     * <p>Note: If {@link #client} is not called a default {@link OkHttpClient} will be created and used.
     */
    public TestIoClientFactory build() {
      if (baseUrl == null) {
        baseUrl = URL;
      }

      if (StringUtils.isBlank(token)) {
        throw new IllegalStateException("Token is required");
      }

      if (client == null) {
        client = new OkHttpClient.Builder()
            .addInterceptor(new AuthInterceptor(token))
            .build();
      } else {
        if (client.interceptors().stream().noneMatch(interceptor -> interceptor instanceof AuthInterceptor)) {
          client = client.newBuilder()
              .addInterceptor(new AuthInterceptor(token))
              .build();
        }
      }

      if (!Level.NONE.equals(loggingLevel) &&
          client.interceptors().stream().noneMatch(interceptor -> interceptor instanceof HttpLoggingInterceptor)) {
        client = client.newBuilder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(loggingLevel))
            .build();
      }

      Moshi moshi = new Moshi.Builder()
          .add(OffsetDateTime.class, new OffsetDateTimeAdapter(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
          .build();

      Retrofit retrofit = new Retrofit.Builder()
          .client(client)
          .baseUrl(baseUrl)
          .addConverterFactory(MoshiConverterFactory.create(moshi))
          .build();

      return new TestIoClientFactory(moshi, retrofit, baseUrl, token, client, loggingLevel);
    }
  }

}
