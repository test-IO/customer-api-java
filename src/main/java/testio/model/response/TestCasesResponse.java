package testio.model.response;

import com.squareup.moshi.Json;
import lombok.*;
import testio.model.response.entity.TestCase;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TestCasesResponse {

    @Json(name = "test_cases")
    List<TestCase> testCases;
}
