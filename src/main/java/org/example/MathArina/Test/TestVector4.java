package org.example.MathArina.Test;

import org.example.MathArina.Vector.Vector4;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestVector4 {

    @Test
    public void testPlus() {
        Vector4 v1 = new Vector4(3, 4, 5, 4);
        Vector4 v2 = new Vector4(1, 2, 3, 4);
        Vector4 result = v1.plus(v2);
        assertEquals(4f, result.getX());
        assertEquals(6f, result.getY());
        assertEquals(8f, result.getZ());
        assertEquals(8f, result.getW());
    }

    @Test
    public void testMinus() {
        Vector4 v1 = new Vector4(3, 4, 5, 4);
        Vector4 v2 = new Vector4(1, 2, 3, 4);
        Vector4 result = v1.minus(v2);
        assertEquals(2f, result.getX());
        assertEquals(2f, result.getY());
        assertEquals(2f, result.getZ());
        assertEquals(0f, result.getW());
    }

    @Test
    public void testMultiply() {
        Vector4 vector = new Vector4(3, 4, 5, 4);
        Vector4 result = vector.multiply(2);
        assertEquals(6f, result.getX());
        assertEquals(8f, result.getY());
        assertEquals(10f, result.getZ());
        assertEquals(8f, result.getW());
    }

    @Test
    public void testDivide() {
        Vector4 vector = new Vector4(6, 8, 10, 8);
        Vector4 result = vector.divide(2);
        assertEquals(3f, result.getX());
        assertEquals(4f, result.getY());
        assertEquals(5f, result.getZ());
        assertEquals(4f, result.getW());
    }

    @Test
    public void testLength() {
        Vector4 vector = new Vector4(2, 3, 4, 5);
        double length = vector.length();
        assertEquals(7.3, length, 0.1);
    }

    @Test
    public void testNormalize() {
        Vector4 vector = new Vector4(3, 4, 5, 4);
        Vector4 result = vector.normalize();
        assertEquals(0.37, result.getX(), 0.1);
        assertEquals(0.49, result.getY(), 0.1);
        assertEquals(0.62, result.getZ(), 0.1);
        assertEquals(0.49, result.getW(), 0.1);
    }

    @Test
    public void testDotProduct() {
        Vector4 v1 = new Vector4(4, 5, 6, 4);
        Vector4 v2 = new Vector4(1, 2, 3, 4);
        float dotProduct = v1.dotProduct(v2);
        assertEquals(48f, dotProduct);
    }
}
