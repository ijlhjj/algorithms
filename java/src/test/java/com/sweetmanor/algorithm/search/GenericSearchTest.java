package com.sweetmanor.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericSearchTest {

    @Test
    void linearContains() {
        assertTrue(GenericSearch.linearContains(List.of(1, 5, 15, 15, 15, 15, 20), 5));
    }

    @Test
    void binaryContains() {
        assertTrue(GenericSearch.binaryContains(List.of("a", "d", "e", "f", "z"), "f"));
        assertFalse(GenericSearch.binaryContains(List.of("john", "mark", "ronald", "sarah"), "sheila"));
    }

}
