package testio.client.examples;

import static testio.model.common.Id.id;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import testio.model.common.TestingType;
import testio.model.request.Attachment;
import testio.model.request.ExploratoryTestRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExploratoryTestRequestExample {

  public static final ExploratoryTestRequest EXPLORATORY_TEST_REQUEST = ExploratoryTestRequest.builder()
      .testTitle("Test title")
      .testTemplate(id(1L))
      .goal("Goal")
      .outOfScope("Out of Scope")
      .instructions("Instructions")
      .startAt(OffsetDateTime.now())
      .duration("2h")
      .reportLanguage("en")
      .testingType(TestingType.COVERAGE)
      .sectionId(2L)
      .requirements(Arrays.asList(id(3L), id(4L)))
      .testEnvironment(id(5L))
      .features(Arrays.asList(id(6L), id(7L), id(8L)))
      .attachments(Collections.singletonList(
          Attachment.builder()
              .fileUrl("https://example.com/img.png")
              .build()
      ))
      .build();

}
