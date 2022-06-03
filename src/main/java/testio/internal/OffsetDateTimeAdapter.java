package testio.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class OffsetDateTimeAdapter extends JsonAdapter<OffsetDateTime> {

  private final DateTimeFormatter formatter;

  @Override
  public OffsetDateTime fromJson(JsonReader reader) throws IOException {
    if (Token.NULL.equals(reader.peek())) {
      return reader.nextNull();
    }
    return OffsetDateTime.parse(reader.nextString(), formatter);
  }

  @Override
  public void toJson(JsonWriter writer, OffsetDateTime value) throws IOException {
    if (value == null) {
      writer.nullValue();
    } else {
      writer.value(value.format(formatter));
    }
  }
}
