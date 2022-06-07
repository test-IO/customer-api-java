package testio.client.examples;

import testio.model.request.TestEnvironmentRequest;
import testio.model.response.TestEnvironmentResponse;
import testio.model.response.TestEnvironmentsResponse;
import testio.model.response.entity.TestEnvironment;

import java.util.Collections;

public final class TestEnvironmentExample {

    public static final TestEnvironment TEST_ENVIRONMENT = TestEnvironment.builder()
            .id(37L)
            .title("White Inc")
            .url("http://will.co/keith")
            .username("terrell_zieme")
            .password("DxFx8S56zNcTuEt")
            .access("Use the neural ADP application, then you can compress the digital bus!")
            .proxy(false)
            .allowOrders(false)
            .accessType("url")
            .build();

    public static final TestEnvironmentResponse TEST_ENVIRONMENT_RESPONSE = TestEnvironmentResponse.builder()
            .testEnvironment(TEST_ENVIRONMENT)
            .build();


    public static final TestEnvironmentsResponse TEST_ENVIRONMENTS_RESPONSE = TestEnvironmentsResponse.builder()
            .testEnvironments(Collections.singletonList(TEST_ENVIRONMENT))
            .build();

    public static final TestEnvironmentRequest TEST_ENVIRONMENT_REQUEST = TestEnvironmentRequest.builder()
            .title("White Inc")
            .url("http://will.co/keith")
            .username("terrell_zieme")
            .password("DxFx8S56zNcTuEt")
            .access("Use the neural ADP application, then you can compress the digital bus!")
            .proxy(false)
            .allowOrders(false)
            .build();
}
