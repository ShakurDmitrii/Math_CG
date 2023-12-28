package org.example.MathArina.Test;

import org.example.MathArina.Matrix.Matrix4x4;
import org.example.MathArina.Vector.Vector4;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestMatrix4x4 {

    @Test
    public void testPlus() {
         float[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
         float[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 m1 = new Matrix4x4(data1);
        Matrix4x4 m2 = new Matrix4x4(data2);
        Matrix4x4 result = m1.plus(m2);
         float[][] expectedData = {
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17}
        };
        assertArrayEquals(expectedData, result.elements());
    }

    @Test
    public void testMinus() {
         float[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
         float[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 m1 = new Matrix4x4(data1);
        Matrix4x4 m2 = new Matrix4x4(data2);
        Matrix4x4 result = m1.minus(m2);
         float[][] expectedData = {
                {-15, -13, -11, -9},
                {-7, -5, -3, -1},
                {1, 3, 5, 7},
                {9, 11, 13, 15}
        };
        assertArrayEquals(expectedData, result.elements());
    }

    @Test
    public void testMultiplyByVector() {
         float[][] matrixData = {
                {2, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 2}
        };
        Matrix4x4 matrix = new Matrix4x4(matrixData);
         float[] vectorData = {1, 2, 3, 4};
        Vector4 vector = new Vector4(vectorData[0], vectorData[1],vectorData[2], vectorData[3]);
        Vector4 result = matrix.multiplyByVector(vector);
        assertEquals(2, result.getX(), 0.01);
        assertEquals(4, result.getY(), 0.01);
        assertEquals(6, result.getZ(), 0.01);
        assertEquals(8, result.getW(), 0.01);
    }

    @Test
    public void testMultiply() {
         float[][] matrixData1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4x4 matrix1 = new Matrix4x4(matrixData1);
         float[][] matrixData2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4x4 matrix2 = new Matrix4x4(matrixData2);
        Matrix4x4 result = matrix1.multiply(matrix2);
         float[][] expectedData = {
                {80, 70, 60, 50},
                {240, 214, 188, 162},
                {400, 358, 316, 274},
                {560, 502, 444, 386}
        };
        assertArrayEquals(expectedData, result.elements());
    }

    @Test
    public void testTranspose() {
         float[][] matrixData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4x4 matrix = new Matrix4x4(matrixData);
        Matrix4x4 transposed = matrix.transpose();
         float[][] expectedData = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };
        assertArrayEquals(expectedData, transposed.elements());
    }

    @Test
    public void testIdentity() {
        Matrix4x4 identity = Matrix4x4.identity();
         float[][] data = identity.elements();
         float[][] expectedData = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        assertArrayEquals(expectedData, data);
    }

    @Test
    public void testZeroMatrix() {
        Matrix4x4 zero = Matrix4x4.zeroMatrix();
         float[][] data = zero.elements();
         float[][] expectedData = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        assertArrayEquals(expectedData, data);
    }

    @Test
    public void testDetermination(){
         float[][] data = {
                {1, 7, 1, 8},
                {4, 6, 11, 8},
                {1, 3, 1, 8},
                {2, 5, 9, 1}
        };
        Matrix4x4 matrix = new Matrix4x4(data);
         float result = matrix.determinant();
        assertEquals(252, result, 0.001);
    }
}