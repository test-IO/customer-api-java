package testio.model.request;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
public final class SearchBugRequest {

  private final ExternalBug bug;

  public SearchBugRequest(@NonNull String externalIdx) {
    this.bug = new ExternalBug(externalIdx);
  }

  @Getter
  @EqualsAndHashCode
  @AllArgsConstructor
  private static final class ExternalBug {

    @Json(name = "external_idx")
    private final String externalIdx;
  }
}
