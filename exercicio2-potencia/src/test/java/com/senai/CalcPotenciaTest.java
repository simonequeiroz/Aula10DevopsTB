package com.senai;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcPotenciaTest {

    private static final double DELTA = 0.001;

    @Test
    void testarPotencia220V() {
        CalcPotencia calc = new CalcPotencia();
        double potencia = calc.calcularPotencia(220, 5);
        // 220 V x 5 A = 1100 W
        assertEquals(1100.0, potencia, DELTA);
    }

    @Test
    void testarPotencia127V() {
        CalcPotencia calc = new CalcPotencia();
        double potencia = calc.calcularPotencia(127, 2.5);
        // 127 V x 2.5 A = 317.5 W
        assertEquals(317.5, potencia, DELTA);
    }
}
