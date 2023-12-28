package org.example.MathArina.Matrix;

import org.example.MathArina.Vector.Vector4;

public record Matrix4x4(float[][] elements) {
    public Matrix4x4 {
        if (elements.length != 4 || elements[0].length != 4 || elements[1].length != 4 || elements[2].length != 4 || elements[3].length != 4) {
            throw new IllegalArgumentException("Тебе сложно написать матрицу 4x4?");
        }
    }

    public Matrix4x4 plus(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 minus(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[i][j] - other.elements[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 multiply(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result[i][j] += this.elements[i][k] * other.elements[k][j];
                }
            }
        }
        return new Matrix4x4(result);
    }

    public Vector4 multiplyByVector(Vector4 vector) {
        float resultX = elements[0][0] * vector.getX() + elements[0][1] * vector.getY() + elements[0][2] * vector.getZ() + elements[0][3] * vector.getW();
        float resultY = elements[1][0] * vector.getX() + elements[1][1] * vector.getY() + elements[1][2] * vector.getZ() + elements[1][3] * vector.getW();
        float resultZ = elements[2][0] * vector.getX() + elements[2][1] * vector.getY() + elements[2][2] * vector.getZ() + elements[2][3] * vector.getW();
        float resultW = elements[3][0] * vector.getX() + elements[3][1] * vector.getY() + elements[3][2] * vector.getZ() + elements[3][3] * vector.getW();
        return new Vector4(resultX, resultY, resultZ, resultW);
    }

    public Matrix4x4 transpose() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[j][i];
            }
        }
        return new Matrix4x4(result);
    }

    public static Matrix4x4 identity() {
        float[][] identityMatrix = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        return new Matrix4x4(identityMatrix);
    }

    public static Matrix4x4 zeroMatrix() {
        float[][] zeroMatrix = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        return new Matrix4x4(zeroMatrix);
    }

    public float determinant() {
        return elements[0][0] * (elements[1][1] * (elements[2][2] * elements[3][3] - elements[2][3] * elements[3][2])
                - elements[1][2] * (elements[2][1] * elements[3][3] - elements[2][3] * elements[3][1])
                + elements[1][3] * (elements[2][1] * elements[3][2] - elements[2][2] * elements[3][1]))
                - elements[0][1] * (elements[1][0] * (elements[2][2] * elements[3][3] - elements[2][3] * elements[3][2])
                - elements[1][2] * (elements[2][0] * elements[3][3] - elements[2][3] * elements[3][0])
                + elements[1][3] * (elements[2][0] * elements[3][2] - elements[2][2] * elements[3][0]))
                + elements[0][2] * (elements[1][0] * (elements[2][1] * elements[3][3] - elements[2][3] * elements[3][1])
                - elements[1][1] * (elements[2][0] * elements[3][3] - elements[2][3] * elements[3][0])
                + elements[1][3] * (elements[2][0] * elements[3][1] - elements[2][1] * elements[3][0]))
                - elements[0][3] * (elements[1][0] * (elements[2][1] * elements[3][2] - elements[2][2] * elements[3][1])
                - elements[1][1] * (elements[2][0] * elements[3][2] - elements[2][2] * elements[3][0])
                + elements[1][2] * (elements[2][0] * elements[3][1] - elements[2][1] * elements[3][0]));
    }
}
