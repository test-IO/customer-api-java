package testio.internal;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public final class AuthInterceptor implements Interceptor {

  private final String token;

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request()
        .newBuilder()
        .addHeader("Authorization", "Token " + token)
        .build();

    return chain.proceed(request);
  }
}
