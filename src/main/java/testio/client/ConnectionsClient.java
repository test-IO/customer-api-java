package testio.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import testio.model.request.CreateConnectionRequest;
import testio.model.request.UpdateConnectionRequest;
import testio.model.response.ConnectionResponse;

public interface ConnectionsClient {

  @POST("connections")
  @Headers({
      "Accept: application/json",
      "Content-Type: application/json"
  })
  Call<ConnectionResponse> createConnection(@Body CreateConnectionRequest.RequestWrapper request);

  @GET("connections/{connection_id}")
  @Headers({
      "Content-Type: application/json"
  })
  Call<ConnectionResponse> fetchConnection(@Path("connection_id") Long id);

  @PUT("connections/{connection_id}")
  @Headers({
      "Accept: application/json",
      "Content-Type: application/json"
  })
  Call<ConnectionResponse> updateConnection(
      @Path("connection_id") Long id, @Body UpdateConnectionRequest.RequestWrapper request);

  @DELETE("connections/{connection_id}")
  @Headers({
      "Content-Type: application/json"
  })
  Call<ConnectionResponse> deleteConnection(@Path("connection_id") Long id);
}
