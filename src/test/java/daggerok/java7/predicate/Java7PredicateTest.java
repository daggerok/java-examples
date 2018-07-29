package daggerok.java7.predicate;

import daggerok.extensions.CaptureSystemOutput;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static daggerok.java7.predicate.Java7Predicate.sideEffect;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@CaptureSystemOutput
@DisplayName("test predicate API: java 7")
class Java7PredicateTest {

    @Test
    @DisplayName("test positive")
    void testPredicate(final CaptureSystemOutput.OutputCapture outputCapture) {

        assertAll(() -> {

            sideEffect(new Java7Predicate.IsRed());
            Assertions.assertThat(outputCapture.toString())
                    .contains("i = red", "i = red devil");

            sideEffect(new Java7Predicate.Is("green"));
            Assertions.assertThat(outputCapture.toString().contains("t = green"));
        });
    }
}