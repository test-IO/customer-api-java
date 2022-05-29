package testio.client.examples;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static testio.model.common.IdName.idName;

import java.time.OffsetDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testio.model.response.TestCaseTestResponse;
import testio.model.response.entity.Requirement;
import testio.model.response.entity.TestCase;
import testio.model.response.entity.TestCaseStep;
import testio.model.response.entity.TestCaseTest;
import testio.model.response.entity.TestEnvironment;
import testio.model.response.entity.TestScenarioRequirement;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestCaseTestResponseExample {

  public static final TestCaseTest TEST_CASE_TEST = TestCaseTest.builder()
      .testTitle(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .goal(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .outOfScope(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .instructions(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .startAt(OffsetDateTime.parse("2022-05-09T11:22:55+02:00"))
      .endAt(OffsetDateTime.parse("2022-05-09T11:22:56+02:00"))
      .reportLanguage("en")
      .testCaseRequirements(singletonList(
          TestScenarioRequirement.builder()
              .id(0L)
              .testCaseEnvironmentId(1L)
              .requirement(Requirement.builder()
                  .category(idName(0L, "Smartphones"))
                  .vendor(idName(0L, "Google"))
                  .devices(asList(
                      idName(null, null),
                      idName(0L, "Nexus 5")
                  ))
                  .operatingSystem(idName(0L, "Android"))
                  .minOperatingSystemVersion(idName(0L, "4.4"))
                  .maxOperatingSystemVersion(idName(0L, "6.0.1"))
                  .browsers(asList(
                      idName(null, null),
                      idName(0L, "Chrome")
                  ))
                  .build())
              .build()
      ))
      .testCases(singletonList(
          TestCase.builder()
              .id(0L)
              .title("")
              .featureId(0L)
              .targetIdx("")
              .steps(singletonList(
                  TestCaseStep.builder()
                      .id(0L)
                      .description("")
                      .testCaseId(0L)
                      .targetIdx("")
                      .build()
              ))
              .build()
      ))
      .testEnvironment(TestEnvironment.builder()
          .id(0L)
          .title("Staging")
          .url("staging.example.com")
          .username("John")
          .password("qwerty")
          .access("Click on the login button")
          .proxy(false)
          .allowOrders(false)
          .build())
      .build();

  public static final TestCaseTestResponse TEST_CASE_TEST_RESPONSE = TestCaseTestResponse.builder()
      .testCaseTest(TEST_CASE_TEST)
      .build();

}
