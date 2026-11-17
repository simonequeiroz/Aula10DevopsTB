package com.senai;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcIMCTest {

    // Tolerância para comparar números com casas decimais (double)
    private static final double DELTA = 0.01;

    @Test
    void testarIMCPesoNormal() {
        CalcIMC calc = new CalcIMC();
        double resultado = calc.calcularIMC(70, 1.75);
        // 70 / (1.75 * 1.75) = 22.86
        assertEquals(22.86, resultado, DELTA);
    }

    @Test
    void testarIMCSobrepeso() {
        CalcIMC calc = new CalcIMC();
        double resultado = calc.calcularIMC(90, 1.80);
        // 90 / (1.80 * 1.80) = 27.78
        assertEquals(27.78, resultado, DELTA);
    }
}
