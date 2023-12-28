package org.example.MathArina.Vector;

public class Vector3 {
    private  float x, y, z;

    public Vector3( float x,  float y,  float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public  float getX() {
        return x;
    }

    public  float getY() {
        return y;
    }

    public  float getZ() {
        return z;
    }

    public Vector3 plus(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 minus(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3 multiply( float scalar) {
        return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3 divide( float scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Мы не делим на 0");
        }
        return new Vector3(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    public  float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3 normalize() {
         float length = length();
        if (length == 0) {
            throw new ArithmeticException("Ты точно хочешь нормализовать 0-вектор?");
        }
        return this.divide(length);
    }

    public  float dotProduct(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector3 crossProduct(Vector3 other) {
         float resultX = this.y * other.z - this.z * other.y;
         float resultY = this.z * other.x - this.x * other.z;
         float resultZ = this.x * other.y - this.y * other.x;
        return new Vector3(resultX, resultY, resultZ);
    }
}
