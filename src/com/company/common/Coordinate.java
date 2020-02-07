package com.company.common;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) throws Exception {
        if (x < 0 || x > 7) throw new Exception("Invalid x:" + x);
        if (y < 0 || y > 7) throw new Exception("Invalid y:" + y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
//So sanh trang thai cua doi so voi trang thai cua doi tuong duoc goi trong cung 1 Class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }
//khi x,y null thi tra ve 0 ma khong nem ra 1 ngoai le nao
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }

    @Override
    public String toString() {
        return "x=" + x + "y" + y;
    }

}
