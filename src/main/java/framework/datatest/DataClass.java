package framework.datatest;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataClass {
    public static Stream<Arguments> msMP(){
        return Stream.of(
                Arguments.of("user","password"),
                Arguments.of("user1","password"),
                Arguments.of("Eve_Berger","eve"));
    }
}
