package com.sweetmanor.exams.greedy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SetCoverTest {

    @Test
    void getBestBroadCasts() {
        SetCover exam = new SetCover();
        assertIterableEquals(new HashSet<>(Set.of("1", "3", "4")), exam.getBestBroadCasts(
                new HashSet<>(Set.of("A", "B", "C", "D", "E", "F", "G", "H", "I")),
                new HashMap<>(
                        Map.of("1", Set.of("A", "B", "D", "E"),
                                "2", Set.of("D", "E", "G", "H"),
                                "3", Set.of("G", "H", "I"),
                                "4", Set.of("C", "F", "I"),
                                "5", Set.of("B", "C")))));
    }

}
