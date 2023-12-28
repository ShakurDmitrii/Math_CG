package org.example.MathArina.Matrix;

import org.example.MathArina.Vector.Vector3;

public record Matrix3x3(float[][] elements) {
    public Matrix3x3 {
        if (elements.length != 3 || elements[0].length != 3 || elements[1].length != 3 || elements[2].length != 3) {
            throw new IllegalArgumentException("Я же просто прошу матрицу 3x3");
        }
    }

    public Matrix3x3 plus(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 minus(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[i][j] - other.elements[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 multiply(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += this.elements[i][k] * other.elements[k][j];
                }
            }
        }
        return new Matrix3x3(result);
    }

    public Vector3 multiplyByVector(Vector3 vector) {
        float resultX = (float) (elements[0][0] * vector.getX() + elements[0][1] * vector.getY() + elements[0][2] * vector.getZ());
        float resultY = (float) (elements[1][0] * vector.getX() + elements[1][1] * vector.getY() + elements[1][2] * vector.getZ());
        float resultZ = (float) (elements[2][0] * vector.getX() + elements[2][1] * vector.getY() + elements[2][2] * vector.getZ());

        return new Vector3(resultX, resultY, resultZ);
    }

    public Matrix3x3 transpose() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[j][i];
            }
        }
        return new Matrix3x3(result);
    }

    public static Matrix3x3 identity() {
        float[][] identityMatrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        return new Matrix3x3(identityMatrix);
    }

    public static Matrix3x3 zeroMatrix() {
        float[][] zeroMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        return new Matrix3x3(zeroMatrix);
    }

    public float determinant() {
        return elements[0][0] * (elements[1][1] * elements[2][2] - elements[1][2] * elements[2][1])
                - elements[0][1] * (elements[1][0] * elements[2][2] - elements[1][2] * elements[2][0])
                + elements[0][2] * (elements[1][0] * elements[2][1] - elements[1][1] * elements[2][0]);
    }
}
