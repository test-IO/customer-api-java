package testio.model.request;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.response.entity.TestCaseStep;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public
class TestCaseRequest {
    private String title;
    private String requirements;
    @Json(name = "feature_id")
    private Long featureId;
    @Json(name = "target_idx")
    private String targetIdx;
    @Json(name = "test_case_steps")
    private List<TestCaseStep> steps;
}
