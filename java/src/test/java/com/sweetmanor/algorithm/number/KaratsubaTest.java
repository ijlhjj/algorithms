package com.sweetmanor.algorithm.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KaratsubaTest {

    //测试10000用时1分33秒
    private static final int LIMIT = 1000;

    @Test
    void test() {
        for (int i = 0; i < LIMIT; i++) {
            for (int j = 0; j < LIMIT; j++) {
                int z = i * j;
                assertEquals(z, Karatsuba.karatsuba(i, j));
                assertEquals(z, Karatsuba.recintmult(i, j));
                assertEquals(z, Karatsuba.recintmult2(i, j));
            }
        }
    }

}
