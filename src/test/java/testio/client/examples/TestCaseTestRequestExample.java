package testio.client.examples;

import static testio.model.common.Id.id;

import java.time.OffsetDateTime;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testio.model.request.TestCaseTestRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestCaseTestRequestExample {

  public static final TestCaseTestRequest TEST_CASE_TEST_REQUEST = TestCaseTestRequest.builder()
      .testTitle("Test title")
      .goal("Goal")
      .outOfScope("OutOfScope")
      .instructions("Instructions")
      .startAt(OffsetDateTime.now())
      .duration("2h")
      .reportLanguage("en")
      .testCases(Arrays.asList(id(1L), id(2L), id(3L)))
      .requirements(Arrays.asList(id(4L), id(5L)))
      .testEnvironment(id(6L))
      .build();
}
