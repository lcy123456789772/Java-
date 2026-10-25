package com.lcy.backendlab.week01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CelsiusTableTest {

    @Test
    void parsesTwoNumbers() {
        int[] actual = CelsiusTable.parseRange(new String[]{"0", "10"});

        assertArrayEquals(new int[]{0, 10}, actual);
    }

    @Test
    void rejectsMissingArguments() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CelsiusTable.parseRange(new String[]{"0"})
        );

        assertEquals("必须提供两个参数", exception.getMessage());
    }

    @Test
    void rejectsNonNumericArguments() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CelsiusTable.parseRange(new String[]{"abc", "10"})
        );

        assertEquals("温度必须是整数", exception.getMessage());
    }

    @Test
    void rejectsReversedRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CelsiusTable.parseRange(new String[]{"10", "0"})
        );

        assertEquals("起始温度不能大于结束温度", exception.getMessage());
    }
}
