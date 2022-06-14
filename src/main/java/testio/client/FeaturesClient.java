package testio.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import testio.model.request.CreateFeatureRequest;
import testio.model.response.FeatureResponse;
import testio.model.response.FeaturesResponse;

public interface FeaturesClient {

  @GET("products/{product_id}/features")
  @Headers({"Content-Type: application/json"})
  Call<FeaturesResponse> listFeatures(@Path("product_id") Long productId);

  @POST("products/{product_id}/features")
  @Headers({"Accept: application/json", "Content-Type: application/json"})
  Call<FeatureResponse> createFeature(
      @Path("product_id") Long productId, @Body CreateFeatureRequest.RequestWrapper request);
}
