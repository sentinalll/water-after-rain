package com.crxmarkets.task.pojo;

/**
 * Created by Roman on 03.05.2016.
 */
public class Unit {
    int leftBorder;
    int rightBorder;
    int widthLeft;
    int widthRight;

    public Unit(int leftBorder, int rightBorder, int widthLeft, int widthRight) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.widthLeft = widthLeft;
        this.widthRight = widthRight;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }

    public int getWidthLeft() {
        return widthLeft;
    }

    public void setWidthLeft(int widthLeft) {
        this.widthLeft = widthLeft;
    }

    public int getWidthRight() {
        return widthRight;
    }

    public void setWidthRight(int widthRight) {
        this.widthRight = widthRight;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "leftBorder=" + leftBorder +
                ", rightBorder=" + rightBorder +
                '}';
    }
}