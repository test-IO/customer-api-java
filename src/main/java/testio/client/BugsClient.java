package testio.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import testio.model.request.FilterBugsRequest;
import testio.model.request.SearchBugRequest;
import testio.model.response.BugResponse;
import testio.model.response.BugsResponse;
import testio.model.response.RejectReasonsResponse;

public interface BugsClient {

  @GET("bugs")
  @Headers({
      "Accept: application/json"
  })
  Call<BugsResponse> fetchBugs();

  @GET("bugs")
  @Headers({
      "Accept: application/json",
  })
  Call<BugsResponse> fetchBugs(@QueryMap FilterBugsRequest request);

  @GET("bugs/{bug_id}")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> fetchBug(@Path("bug_id") Long id);

  @POST("bugs/search")
  @Headers({
      "Accept: application/json",
      "Content-Type: application/json"
  })
  Call<BugResponse> searchBug(@Body SearchBugRequest request);

  @GET("bugs/reject_reasons")
  @Headers({
      "Accept: application/json"
  })
  Call<RejectReasonsResponse> fetchRejectReasons();

  @PUT("bugs/{bug_id}/accept")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> acceptBug(@Path("bug_id") Long bugId);

  @PUT("bugs/{bug_id}/mark_as_exported")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> markAsExported(@Path("bug_id") Long bugId);

  @PUT("bugs/{bug_id}/mark_as_known")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> markAsKnown(@Path("bug_id") Long bugId);

  @PUT("bugs/{bug_id}/mark_as_fixed")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> markAsFixed(@Path("bug_id") Long bugId);

  @PUT("bugs/{bug_id}/reject")
  @Headers({
      "Accept: application/json"
  })
  Call<BugResponse> rejectBug(@Path("bug_id") Long bugId, @Query("reason") String reason,
      @Query("comment") String comment);
}
