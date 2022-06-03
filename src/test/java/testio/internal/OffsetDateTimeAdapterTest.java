package testio.internal;

import static org.assertj.core.api.Assertions.assertThat;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class OffsetDateTimeAdapterTest {

  static final String DATE_TIME = "2022-05-18T10:36:43.567+02:00";
  
  Moshi moshi = new Moshi.Builder()
      .add(OffsetDateTime.class, new OffsetDateTimeAdapter(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
      .build();
  JsonAdapter<OffsetDateTime> adapter = moshi.adapter(OffsetDateTime.class);


  @Test
  void verifyFromJsonNull() throws IOException {
    assertThat(adapter.fromJson("null")).isNull();
  }

  @Test
  void verifyFromJsonValue() throws IOException {
    assertThat(adapter.fromJson("\"" + DATE_TIME + "\"")).isEqualTo(DATE_TIME);
  }

  @Test
  void verifyNullToJson() {
    assertThat(adapter.toJson(null)).isEqualTo("null");
  }

  @Test
  void verifyValueToJson() {
    assertThat(adapter.toJson(OffsetDateTime.parse(DATE_TIME))).isEqualTo("\"" + DATE_TIME + "\"");
  }
}
