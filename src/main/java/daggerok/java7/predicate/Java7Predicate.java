package daggerok.java7.predicate;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;
//tag::content[]
public class Java7Predicate {

    public interface MyPredicate {
        boolean test(final String value);
    }

    @RequiredArgsConstructor
    public static class Is implements MyPredicate {
        final String value;

        @Override
        public boolean test(String value) {
            return value != null && value.contains(this.value);
        }
    }

    public static class IsRed implements MyPredicate {
        @Override
        public boolean test(final String value) {
            return nonNull(value) && value.toLowerCase().contains("red");
        }
    }

    public static void sideEffect(final MyPredicate predicate) {
        final List<String> list = Arrays.asList("ololo", "trololo", "red", "blue", "green", "red devil");
        for (String i : list) {
            if (predicate.test(i)) {
                System.out.println("i = " + i);
            }
        }
    }
}
//end::content[]
