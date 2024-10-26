package com.sweetmanor.exams.linear;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class JosephCircleTest {

    @Test
    void solve() {
        JosephCircle exam = new JosephCircle();
        exam.createJosephCircle(new int[]{3, 1, 7, 2, 4, 8, 4}); //创建约瑟夫环
        List<Integer> ans = exam.solve(6);
        assertIterableEquals(List.of(6, 1, 4, 7, 2, 3, 5), ans);
    }

}
