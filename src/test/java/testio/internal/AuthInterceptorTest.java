package testio.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthInterceptorTest {

  @Mock
  Chain chain;

  @Test
  void verifyIntercept() throws Exception {
    ArgumentCaptor<Request> requestCaptor = ArgumentCaptor.forClass(Request.class);
    Request request = new Builder()
        .url("http://example.com/")
        .get()
        .build();
    when(chain.request()).thenReturn(request);
    when(chain.proceed(any())).thenReturn(new Response.Builder()
        .code(200)
        .protocol(Protocol.HTTP_1_1)
        .message("OK")
        .request(request)
        .build());

    new AuthInterceptor("abc").intercept(chain);

    verify(chain).proceed(requestCaptor.capture());

    assertThat(requestCaptor.getValue().header("Authorization")).isEqualTo("Token abc");
  }
}
