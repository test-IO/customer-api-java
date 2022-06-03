package testio.model.response.entity;

import com.squareup.moshi.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testio.model.WithId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BinaryApp implements WithId {

  private Long id;
  private String filename;
  @Json(name = "file_size")
  private Long fileSize;
}
