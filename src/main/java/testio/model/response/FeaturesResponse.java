package testio.model.response;

import lombok.*;
import testio.model.response.entity.Feature;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FeaturesResponse {
    List<Feature> features;
}
