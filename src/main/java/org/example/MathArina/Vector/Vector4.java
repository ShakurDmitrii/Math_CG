package org.example.MathArina.Vector;

public class Vector4 {
    private final float x;
    private float y;
    private float z;
    private float w;

    public Vector4( float x,  float y,  float z,  float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public  float getW() {
        return w;
    }

    public Vector4 plus(Vector4 other) {
        return new Vector4(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    public Vector4 minus(Vector4 other) {
        return new Vector4(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    public Vector4 multiply( float scalar) {
        return new Vector4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    public Vector4 divide( float scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Мы не делим на 0");
        }
        return new Vector4(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    public  float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Vector4 normalize() {
         float length = length();
        if (length == 0) {
            throw new ArithmeticException("Ты точно хочешь нормализовать 0-вектор?");
        }
        return this.divide(length);
    }

    public  float dotProduct(Vector4 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
    }
}
