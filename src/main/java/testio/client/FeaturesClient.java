package testio.client;

import retrofit2.Call;
import retrofit2.http.*;
import testio.model.request.CreateFeatureRequest;
import testio.model.response.FeatureResponse;
import testio.model.response.FeaturesResponse;

public interface FeaturesClient {

  @GET("products/{product_id}/features")
  @Headers({
          "Content-Type: application/json"
  })
  Call<FeaturesResponse> listFeatures(@Path("product_id") Long productId);

  @POST("products/{product_id}/features")
  @Headers({
          "Accept: application/json",
          "Content-Type: application/json"
  })
  Call<FeatureResponse> createFeature(
      @Path("product_id") Long productId, @Body CreateFeatureRequest.RequestWrapper request);
}
