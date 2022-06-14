package testio.client.examples;

import java.util.Collections;
import testio.model.request.CreateFeatureRequest;
import testio.model.response.FeatureResponse;
import testio.model.response.FeaturesResponse;
import testio.model.response.entity.Feature;

public final class FeatureExample {

  public static final Feature FEATURE =
      Feature.builder()
          .id(1L)
          .title("Account")
          .description("Manage your account information")
          .howtofind("Top right of the screen")
          .userStories(Collections.singletonList("user stories you want to test"))
          .build();

  public static final FeatureResponse FEATURE_RESPONSE =
      FeatureResponse.builder()
          .feature(
              Feature.builder()
                  .id(1L)
                  .title("Account")
                  .description("Manage your account information")
                  .howtofind("Top right of the screen")
                  .build())
          .build();

  public static final FeaturesResponse FEATURES_RESPONSE =
      FeaturesResponse.builder().features(Collections.singletonList(FEATURE)).build();

  public static final CreateFeatureRequest CREATE_FEATURE_REQUEST =
      CreateFeatureRequest.builder()
          .title("Account")
          .description("Manage your account information")
          .howtofind("Top right of the screen")
          .build();
}
