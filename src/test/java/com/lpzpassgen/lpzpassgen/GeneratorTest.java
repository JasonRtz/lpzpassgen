package com.lpzpassgen.lpzpassgen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {

    @Test
    public void rejectsLengthSmallerThanSelectedTypes() {

        Generator generator = new Generator(true, true, true, 2);

        assertThrows(
                IllegalArgumentException.class,
                generator::generatePassword
        );
    }

    @Test
    public void generatesPasswordWithCorrectLength() {

        Generator generator = new Generator(true, true, true, 12);

        String password = generator.generatePassword();

        assertEquals(12, password.length());
    }
}