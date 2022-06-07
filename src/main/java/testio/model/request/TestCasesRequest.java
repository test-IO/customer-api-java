package testio.model.request;

import com.squareup.moshi.Json;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCasesRequest {

    @Json(name = "test_cases")
    List<TestCaseRequest> testCaseRequests;

}