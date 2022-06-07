package testio.model.response;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.TestEnvironment;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TestEnvironmentResponse {

    @Json(name = "test_environment")
    TestEnvironment testEnvironment;
}
