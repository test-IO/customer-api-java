package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.BinaryApp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestEnvironmentRequest {

    private Long id;
    private String title;
    private String url;
    private String username;
    private String password;
    private String access;
    private Boolean proxy;
    @Json(name = "allow_orders")
    private Boolean allowOrders;
    @Json(name = "access_type")
    private String accessType;
    @Json(name = "binary_app")
    private BinaryApp binaryApp;

    public TestEnvironmentRequest.RequestWrapper buildRequest() {
        return new TestEnvironmentRequest.RequestWrapper(this);
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    public static class RequestWrapper {

        @Json(name = "test_environment")
        TestEnvironmentRequest testEnvironmentRequest;
    }
}
