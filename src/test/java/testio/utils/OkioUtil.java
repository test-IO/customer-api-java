package testio.utils;

import java.io.IOException;
import java.io.InputStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import okio.Okio;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OkioUtil {

  public static String resourceToString(String resource) {
    InputStream stream = OkioUtil.class.getResourceAsStream(resource);
    if (stream != null) {
      try {
        return Okio.buffer(Okio.source(stream)).readUtf8();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    throw new IllegalArgumentException("Resource not found: " + resource);
  }
}
