package testio.client;

import retrofit2.Call;
import retrofit2.http.*;
import testio.model.request.TestEnvironmentRequest;
import testio.model.response.TestEnvironmentResponse;
import testio.model.response.TestEnvironmentsResponse;

public interface TestEnvironmentsClient {

  @GET("products/{product_id}/test_environments")
  @Headers({
          "Content-type: application/json"
  })
  Call<TestEnvironmentsResponse> listTestEnvironments(@Path("product_id") Long productId);

  @POST("products/{product_id}/test_environments")
  @Headers({
          "Accept: application/json",
          "Content-type: application/json"
  })
  Call<TestEnvironmentResponse> createTestEnvironment(
      @Path("product_id") Long productId, @Body TestEnvironmentRequest.RequestWrapper request);

  @DELETE("products/{product_id}/test_environments/{test_environment_id}")
  @Headers({
          "Content-type: application/json"
  })
  Call<TestEnvironmentResponse> deleteTestEnvironment(
      @Path("product_id") Long productId, @Path("test_environment_id") Long id);
}
