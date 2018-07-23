package com.ngdroidapp.FirebaseConnection;


public class Character {
    private String name;
    private int x;
    private int y;
    private int line;
    private int row;
    private int elementid;

    public Character() {

    }

    public Character(String name, int x, int y, int line, int row, int elementid) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.line = line;
        this.row = row;
        this.elementid = elementid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getElementid() {
        return elementid;
    }

    public void setElementid(int elementid) {
        this.elementid = elementid;
    }
}