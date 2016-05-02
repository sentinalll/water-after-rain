package com.crxmarketx.task.pojo;

/**
 * Created by Roman on 03.05.2016.
 */
public class Gap {
    int leftBorder;
    int rightBorder;
    int widthLeft;
    int widthRight;

    public Gap() {
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
        return "Gap{" +
                "leftBorder=" + leftBorder +
                ", rightBorder=" + rightBorder +
                '}';
    }
}