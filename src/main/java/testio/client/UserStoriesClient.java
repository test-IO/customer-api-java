package testio.client;

import retrofit2.Call;
import retrofit2.http.*;
import testio.model.request.CreateUserStoryRequest;
import testio.model.request.UpdateUserStoryRequest;
import testio.model.response.UserStoriesResponse;
import testio.model.response.UserStoryResponse;

public interface UserStoriesClient {

    @GET("products/{product_id}/user_stories")
    @Headers({
            "Content-Type: application/json"
    })
    Call<UserStoriesResponse> listUserStories(@Path("product_id") Long productId);

    @POST("products/{product_id}/user_stories")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<UserStoryResponse> createUserStory(
            @Path("product_id") Long productId,
            @Body CreateUserStoryRequest.RequestWrapper request
    );

    @DELETE("products/{product_id}/user_stories/{user_story_id}")
    @Headers({
            "Content-Type: application/json"
    })
    Call<UserStoryResponse> deleteUserStory(@Path("product_id") Long productId, @Path("user_story_id") Long userStoryId);

    @PUT("products/{product_id}/user_stories/{user_story_id}")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<UserStoryResponse> updateUserStory(
            @Path("product_id") Long productId,
            @Path("user_story_id") Long userStoryId,
            @Body UpdateUserStoryRequest.RequestWrapper request
    );
}
