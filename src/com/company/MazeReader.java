package com.company;

import java.io.*;
import java.util.*;

public class MazeReader {

    private List<Node> mazeInNode = new ArrayList<>();
    private Node start;
    private Node end;


    public MazeReader(String fileNameWithTxt) {


        try {
            File file = new File("C:\\Users\\PC\\IdeaProjects\\kolos\\" + fileNameWithTxt);
            Scanner sc = null;
            sc = new Scanner(file);
            int j = 0;
            while (sc.hasNextLine()) {
                // System.out.println(sc.nextLine());
                String string = sc.nextLine();
                for (int i = 0; i < string.length(); i++) {//kolumna
                    Node node=null;
                    if (isEmpty(string.charAt(i))) {
                        node = new Node(i, j, ' ');
                        mazeInNode.add(node);
                    } else if (isStart(string.charAt(i))) {
                        node = new Node(i, j, 'S');
                        start = node;
                        mazeInNode.add(node);
                    } else if (isStop(string.charAt(i))) {
                        node = new Node(i, j, 'E');
                        end = node;
                        mazeInNode.add(node);
                    }

                    //mazeInNode.add(node);
                }
                j++;//wiersz
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    boolean isEmpty(Character c) {
        if (c == ' ') {
            return true;
        }
        return false;
    }

    boolean isWall(Character c) {
        if (c == '#') {
            return true;
        }
        return false;
    }

    boolean isStart(Character c) {
        if (c == 'S') {
            return true;
        }
        return false;
    }

    boolean isStop(Character c) {
        if (c == 'E') {
            return true;
        }
        return false;
    }


    public List<Node> getMazeInNode() {
        return mazeInNode;
    }


}







