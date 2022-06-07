package testio.model.response;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.TestEnvironment;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TestEnvironmentsResponse {

    @Json(name = "test_environments")
    List<TestEnvironment>  testEnvironments;
}
