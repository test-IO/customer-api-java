package testio.model.response;

import lombok.*;
import testio.model.response.entity.Feature;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FeatureResponse {
  Feature feature;
}
