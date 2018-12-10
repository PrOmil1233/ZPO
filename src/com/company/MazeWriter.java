package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeWriter {
    private List<Node> mazeInNode = new ArrayList<>();
    private List<Node> wynik = new ArrayList<>();

    public MazeWriter(List<Node> mazeInNode, List<Node> wynik) {
        this.mazeInNode = mazeInNode;
        this.wynik = wynik;
    }

    void saveFile() {
        try {
            File file = new File("C:\\Users\\PC\\IdeaProjects\\kolos\\wynik.txt");
            FileWriter fw= new FileWriter(file);
           String wynik ="";
            for(int i=0;i<21;i++){
                for(int j=0;j<21;j++){
                    if(mazeInNode.contains(new Node(i,j))){
                        wynik+=mazeInNode.get(mazeInNode.indexOf(new Node(i,j)));
                    }else{
                        wynik+="#";
                    }

                }
                wynik+="\n";
            }
            fw.write(wynik,0,wynik.length());
            fw.close();

    } catch(
    IOException x)
    {
        System.err.format("IOException: %s%n", x);
    }

        ////


}

    void drawStep() {

        for (Node node : wynik) {
            if (mazeInNode.contains(node)) {
                mazeInNode.set(mazeInNode.indexOf(node), new Node(node.getX(), node.getY(), '@'));
            }
            //  mazeInNode.set(node.getX() + node.getY() * node.getX(), new Node(node.getX(), node.getY(), 'a'));
        }
      //  System.out.println(mazeInNode);
    }
}
