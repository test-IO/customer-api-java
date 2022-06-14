package testio.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import testio.model.request.TestCasesRequest;
import testio.model.response.TestCasesResponse;

public interface TestCasesClient {

  @POST("products/{product_id}/test_cases")
  @Headers({
      "Accept: application/json",
      "Content-type: application/json"
  })
  Call<TestCasesResponse> createTestCases(
      @Path("product_id") Long productId, @Body TestCasesRequest request);
}
