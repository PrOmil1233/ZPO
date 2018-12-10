package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MazeReader mazeReader = new MazeReader("map_21x21.txt");
        BFS bfs = new BFS(mazeReader.getMazeInNode());
        ArrayList<Node> wynik = bfs.BBFS(mazeReader.getStart(),mazeReader.getEnd());

        MazeWriter mw = new MazeWriter(mazeReader.getMazeInNode(),wynik);
        mw.drawStep();
    mw.saveFile();
//        System.out.println(wynik);
        System.out.println("l");
    }
}
