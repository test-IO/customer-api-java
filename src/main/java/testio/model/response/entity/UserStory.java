package testio.model.response.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStory implements WithId {

    private Long id;
    private String path;
    private String title;

}
