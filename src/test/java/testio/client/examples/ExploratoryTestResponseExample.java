package testio.client.examples;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static testio.model.common.IdName.idName;

import java.time.OffsetDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testio.model.common.IdName;
import testio.model.common.TestingType;
import testio.model.response.ExploratoryTestResponse;
import testio.model.response.ExploratoryTestsResponse;
import testio.model.response.entity.ExploratoryTest;
import testio.model.response.entity.Product;
import testio.model.response.entity.Requirement;
import testio.model.response.entity.TestEnvironment;
import testio.model.response.entity.TestFeature;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExploratoryTestResponseExample {

  public static final ExploratoryTest EXPLORATORY_TEST = ExploratoryTest.builder()
      .id(1234L)
      .testTitle(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
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
      .features(singletonList(
          TestFeature.builder()
              .id(0L)
              .title("Account")
              .description("Manage your account information")
              .howtofind("Top right of the screen")
              .userStories(singletonList("user stories you want to test"))
              .build()
      ))
      .goal(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .outOfScope(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .instructions(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
      .testingType(TestingType.COVERAGE)
      .requirements(singletonList(
          Requirement.builder()
              .category(IdName.builder()
                  .id(0L)
                  .name("Smartphones")
                  .build())
              .vendor(IdName.builder()
                  .id(0L)
                  .name("Google")
                  .build())
              .devices(asList(
                  idName(null, null),
                  idName(0L, "Nexus 5")
              ))
              .operatingSystem(IdName.builder()
                  .id(0L)
                  .name("Android")
                  .build())
              .minOperatingSystemVersion(IdName.builder()
                  .id(0L)
                  .name("4.4")
                  .build())
              .maxOperatingSystemVersion(IdName.builder()
                  .id(0L)
                  .name("6.0.1")
                  .build())
              .browsers(asList(
                  idName(null, null),
                  idName(0L, "Chrome")
              ))
              .build()
      ))
      .reportLanguage("en")
      .section(IdName.builder()
          .id(14L)
          .name("Section #2")
          .build())
      .product(Product.builder()
          .id(0L)
          .name("Name of the product")
          .sections(asList(
              idName(13L, "Section #1"),
              idName(14L, "Section #2"),
              idName(15L, "Section #3")
          ))
          .build())
      .startAt(OffsetDateTime.parse("2022-05-09T11:22:55.000+02:00"))
      .endAt(OffsetDateTime.parse("2022-05-09T11:24:55.000+02:00"))
      .build();

  public static final ExploratoryTestsResponse EXPLORATORY_TESTS_RESPONSE = ExploratoryTestsResponse.builder()
      .exploratoryTests(singletonList(EXPLORATORY_TEST))
      .build();

  public static final ExploratoryTestResponse EXPLORATORY_TEST_RESPONSE = ExploratoryTestResponse.builder()
      .exploratoryTest(EXPLORATORY_TEST)
      .build();


}
