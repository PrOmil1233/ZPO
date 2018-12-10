package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {

    List<Node> Neightbourd = new ArrayList<>();
    private int x;
    private int y;
    private Character symbol = ' ';

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, Character c) {
        this.x = x;
        this.y = y;
        this.symbol = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSymbol(Character c) {
        this.symbol = c;
    }

    @Override
    public int hashCode() {
        return getY()*21+getX()*37;
    }

    @Override
    public boolean equals(Object obj) {
        Node temp = (Node) obj;
        if(this.getX() != temp.getX() || this.getY() != temp.getY()){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return symbol.toString();//"("+getX()+" "+ getY()+")";
    }
}
