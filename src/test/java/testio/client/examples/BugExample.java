package testio.client.examples;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static testio.model.common.IdName.idName;
import static testio.model.common.Name.name;

import java.time.OffsetDateTime;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testio.model.common.Severity;
import testio.model.common.Status;
import testio.model.response.BugResponse;
import testio.model.response.BugsResponse;
import testio.model.response.entity.BinaryApp;
import testio.model.response.entity.Bug;
import testio.model.response.entity.BugComment;
import testio.model.response.entity.BugTest;
import testio.model.response.entity.DeviceReport;
import testio.model.response.entity.Feature;
import testio.model.response.entity.Product;
import testio.model.response.entity.ReportAttachment;
import testio.model.response.entity.TestEnvironment;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BugExample {

  public static final Bug BUG = Bug.builder()
      .id(20L)
      .title("Summary of the bug")
      .severity(Severity.HIGH)
      .status(Status.ACCEPTED)
      .language("en")
      .feature(Feature.builder()
          .id(61L)
          .title("Landing Page")
          .description(
              "You are on the landing page. It often shows a slideshow at the center, but also tiles related to current offers or themes.\r\nThe site should be displayed in the same way among all common browsers.\r\nCustomer references / reviews are often present towards the bottom of the page.\r\n")
          .location("The landing page of the given testing environment")
          .howtofind("The landing page of the given testing environment")
          .targetIdx("unknown")
          .build())
      .location("test_url3.com")
      .expectedResult("Expected result")
      .actualResult("Actual result")
      .author(name("teamleader1"))
      .comments(singletonList(
          BugComment.builder()
              .id(123L)
              .body("comment message")
              .author(name("toto"))
              .createdAt(OffsetDateTime.parse("2022-05-09T11:22:55.000+02:00"))
              .build()
      ))
      .devices(singletonList(
          DeviceReport.builder()
              .id(43L)
              .category(name("Smartphones"))
              .vendor(name("Google"))
              .device(name("Nexus 5"))
              .operatingSystem(name("Android"))
              .operatingSystemVersion(name("10"))
              .browsers(singletonList(name("Chrome")))
              .build()
      ))
      .exportedAt(OffsetDateTime.parse("2022-05-09T11:22:55.000+02:00"))
      .externalIdx("abcdefg")
      .known(false)
      .product(Product.builder()
          .id(10L)
          .name("Product #2")
          .sections(asList(
              idName(13L, "Section #1"),
              idName(14L, "Section #2"),
              idName(15L, "Section #3")
          ))
          .build())
      .section(idName(14L, "Section #2"))
      .attachments(singletonList(
          ReportAttachment.builder()
              .id(51L)
              .url("https://example.com/uploads/bug_attachment/file/51/6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg")
              .thumbnailUrls(new HashMap<String, String>() {{
                put("50x50",
                    "https://example.com/uploads/bug_attachment/file/51/thumb_6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg");
                put("150x150",
                    "https://example.com/uploads/bug_attachment/file/51/inline_6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg");
                put("200x200",
                    "https://example.com/uploads/bug_attachment/file/51/preview_6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg");
                put("x250",
                    "https://example.com/uploads/bug_attachment/file/51/carousel_6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg");
                put("50x36",
                    "https://example.com/uploads/bug_attachment/file/51/upload_bar_6d96f62c-1efd-47a6-a04b-a60ab5426cdb.jpg");
              }})
              .build()
      ))
      .reproductions(emptyList())
      .steps(singletonList("Go to Url"))
      .test(BugTest.builder()
          .id(37L)
          .title("Product with sections")
          .build())
      .testEnvironment(TestEnvironment.builder()
          .id(9L)
          .title("new")
          .url("http://test.com")
          .username("user")
          .password("password")
          .access("")
          .proxy(false)
          .allowOrders(false)
          .accessType("url")
          .binaryApp(BinaryApp.builder()
              .id(45L)
              .filename("f.txt")
              .fileSize(123L)
              .build())
          .build())
      .reportedAt(OffsetDateTime.parse("2022-05-18T10:36:43.000+02:00"))
      .build();

  public static final BugsResponse BUGS_RESPONSE = BugsResponse.builder()
      .bugs(singletonList(BUG))
      .build();

  public static final BugResponse BUG_RESPONSE = BugResponse.builder()
      .bug(BUG)
      .build();
}
