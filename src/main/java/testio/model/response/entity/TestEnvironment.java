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
public class TestEnvironment implements WithId {

  private Long id;
  private String title;
  private String url;
  private String username;
  private String password;
  private String access;
  private Boolean proxy;
  @Json(name = "allow_orders")
  private Boolean allowOrders;
  @Json(name = "access_type")
  private String accessType;
  @Json(name = "binary_app")
  private BinaryApp binaryApp;
}
