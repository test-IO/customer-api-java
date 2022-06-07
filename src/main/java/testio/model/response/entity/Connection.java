package testio.model.response.entity;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Connection implements WithId {

    private Long id;
    private String name;
    private String url;
    private boolean fixed;
    @Json(name = "product_ids")
    private List<Long> productIds;
    @Json(name = "section_ids")
    private List<Long> sectionIds;

}
