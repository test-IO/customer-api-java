package testio.client.examples;

import java.util.Collections;
import testio.model.request.TestCaseRequest;
import testio.model.request.TestCasesRequest;
import testio.model.response.TestCasesResponse;
import testio.model.response.entity.TestCase;
import testio.model.response.entity.TestCaseStep;

public final class TestCaseExample {

  public static final TestCasesResponse TEST_CASES_RESPONSE =
      TestCasesResponse.builder()
          .testCases(
              Collections.singletonList(
                  TestCase.builder()
                      .id(1L)
                      .title("New test case")
                      .featureId(1L)
                      .steps(
                          Collections.singletonList(
                              TestCaseStep.builder()
                                  .id(1L)
                                  .testCaseId(1L)
                                  .description("First step")
                                  .build()))
                      .build()))
          .build();

  public static final TestCasesRequest BULK_TEST_CASE_REQUEST =
      TestCasesRequest.builder()
          .testCaseRequests(
              Collections.singletonList(
                  TestCaseRequest.builder()
                      .title("New test case")
                      .featureId(1L)
                      .steps(
                          Collections.singletonList(
                              TestCaseStep.builder().description("First step").build()))
                      .build()))
          .build();
}
