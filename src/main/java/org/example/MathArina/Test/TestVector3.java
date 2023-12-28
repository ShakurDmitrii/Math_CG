package org.example.MathArina.Test;

import org.example.MathArina.Vector.Vector3;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestVector3 {

    @Test
    public void testPlus() {
        Vector3 v1 = new Vector3(3 , 4 , 5 );
        Vector3 v2 = new Vector3(1 , 2 , 3 );
        Vector3 result = v1.plus(v2);
        assertEquals(4 , result.getX());
        assertEquals(6 , result.getY());
        assertEquals(8 , result.getZ());
    }

    @Test
    public void testMinus() {
        Vector3 v1 = new Vector3(3 , 4 , 5 );
        Vector3 v2 = new Vector3(1 , 2 , 3 );
        Vector3 result = v1.minus(v2);
        assertEquals(2.0f, result.getX());
        assertEquals(2.0f, result.getY());
        assertEquals(2.0f, result.getZ());
    }

    @Test
    public void testMultiply() {
        Vector3 vector = new Vector3(3 , 4 , 5 );
        Vector3 result = vector.multiply(2 );
        assertEquals(6f, result.getX());
        assertEquals(8f, result.getY());
        assertEquals(10f, result.getZ());
    }

    @Test
    public void testDivide() {
        Vector3 vector = new Vector3(6 , 8 , 10 );
        Vector3 result = vector.divide(2 );
        assertEquals(3f , result.getX());
        assertEquals(4f, result.getY());
        assertEquals(5f , result.getZ());
    }

    @Test
    public void testLength() {
        Vector3 vector = new Vector3(2 , 3 , 4 );
        double length = vector.length();
        assertEquals(5.4, length, 0.1);
    }

    @Test
    public void testNormalize() {
        Vector3 vector = new Vector3(3 , 4 , 5 );
        Vector3 result = vector.normalize();
        assertEquals(0.42, result.getX(), 0.1);
        assertEquals(0.56, result.getY(), 0.1);
        assertEquals(0.7, result.getZ(), 0.1);
    }

    @Test
    public void testDotProduct() {
        Vector3 v1 = new Vector3(4 , 5 , 6 );
        Vector3 v2 = new Vector3(1 , 2 , 3 );
        float dotProduct = v1.dotProduct(v2);
        assertEquals(32f, dotProduct);
    }
    @Test
    public void testCrossProduct(){
        Vector3 v1 = new Vector3(4 , 5 , 6 );
        Vector3 v2 = new Vector3(1 , 2 , 3 );
        Vector3 result = v1.crossProduct(v2);
        assertEquals(3f, result.getX());
        assertEquals(-6f, result.getY());
        assertEquals(3f, result.getZ());
    }
}