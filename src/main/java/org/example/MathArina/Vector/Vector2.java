package org.example.MathArina.Vector;

public class Vector2 {
    private float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2 plus(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 minus(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 multiply(float scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }

    public Vector2 divide(float scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Мы не делим на 0");
        }
        return new Vector2(this.x / scalar, this.y / scalar);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2 normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Ты точно хочешь нормализовать 0-вектор?");
        }
        return this.divide(length);
    }

    public float dotProduct(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }
}
