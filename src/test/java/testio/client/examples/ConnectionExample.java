package testio.client.examples;

import testio.model.request.CreateConnectionRequest;
import testio.model.request.UpdateConnectionRequest;
import testio.model.response.ConnectionResponse;
import testio.model.response.entity.Connection;

public final class ConnectionExample {

    public static final Connection CONNECTION = Connection.builder()
            .id(123L)
            .name("name of the connection")
            .url("url of the connection")
            .fixed(false)
            .build();

    public static final ConnectionResponse CONNECTION_RESPONSE = ConnectionResponse.builder()
            .connection(CONNECTION)
            .build();

    public static final CreateConnectionRequest CREATE_CONNECTION_REQUEST = CreateConnectionRequest.builder()
            .name("name of the connection")
            .url("url of the connection")
            .fixed(false)
            .build();

    public static final UpdateConnectionRequest UPDATE_CONNECTION_REQUEST = UpdateConnectionRequest.builder()
            .name("name of the connection")
            .url("url of the connection")
            .fixed(false)
            .build();
}
