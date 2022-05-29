package testio.client;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import testio.model.request.ExploratoryTestRequest.RequestWrapper;
import testio.model.request.TestCaseTestRequest;
import testio.model.response.ExploratoryTestResponse;
import testio.model.response.ExploratoryTestsResponse;
import testio.model.response.TestCaseTestResponse;

public interface TestsClient {

  /**
   * Returns the last 150 tests without pagination for a given Product.
   */
  @GET("products/{product_id}/exploratory_tests")
  @Headers({
      "Accept: application/json"
  })
  Call<ExploratoryTestsResponse> fetchExploratoryTests(@Path("product_id") Long productId);

  /**
   * Creates exploratory test for a given Product.
   */
  @POST("products/{product_id}/exploratory_tests")
  @Headers({
      "Accept: application/json",
      "Content-type: application/json"
  })
  Call<ExploratoryTestResponse> createExploratoryTest(@Path("product_id") Long productId,
      @Body RequestWrapper request);

  /**
   * Creates a test case test for a given Product.
   *
   * @return {@link Call} see
   */
  @POST("products/{product_id}/test_case_test")
  @Headers({
      "Accept: application/json",
      "Content-type: application/json"
  })
  Call<TestCaseTestResponse> createTestCaseTest(@Path("product_id") Long productId,
      @Body TestCaseTestRequest.RequestWrapper request);
}
