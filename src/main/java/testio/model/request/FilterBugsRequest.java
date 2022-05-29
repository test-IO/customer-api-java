package testio.model.request;

import com.squareup.moshi.Json;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class FilterBugsRequest extends HashMap<String, String> {

  public static SearchBugsRequestBuilder builder() {
    return new SearchBugsRequestBuilder();
  }

  @NoArgsConstructor
  public static class SearchBugsRequestBuilder {

    private final FilterBugsRequest request = new FilterBugsRequest();

    public SearchBugsRequestBuilder filterProductIds(@NonNull List<Long> productIds) {
      request.put("filter_product_ids", productIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      return this;
    }

    public SearchBugsRequestBuilder filterSectionIds(@NonNull List<Long> sectionIds) {
      request.put("filter_section_ids", sectionIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      return this;
    }

    public SearchBugsRequestBuilder filterTestCycleIds(@NonNull List<Long> testCycleIds) {
      request.put("filter_test_cycle_ids", testCycleIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      return this;
    }

    public SearchBugsRequestBuilder filterBugIds(@NonNull List<Long> bugIds) {
      request.put("filter_bug_ids", bugIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      return this;
    }

    public SearchBugsRequestBuilder exportStatus(@NonNull ExportStatus exportStatus) {
      request.put("export_status", exportStatus.value());
      return this;
    }

    public SearchBugsRequestBuilder query(@NonNull String query) {
      request.put("query", query);
      return this;
    }

    public FilterBugsRequest build() {
      return request;
    }
  }

  public enum ExportStatus {
    @Json(name = "exported")
    EXPORTED,
    @Json(name = "export_requested")
    EXPORT_REQUESTED,
    @Json(name = "not_exported")
    NOT_EXPORTED;

    public String value() {
      return name().toLowerCase();
    }
  }
}
