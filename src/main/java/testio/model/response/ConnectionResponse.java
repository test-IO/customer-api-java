package testio.model.response;

import lombok.*;
import testio.model.response.entity.Connection;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ConnectionResponse {

  Connection connection;
}
