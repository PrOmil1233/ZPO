package com.company;

import java.util.*;

public class BFS {

    private List<Node> mazeInNode = new ArrayList<>();

    public BFS(List<Node> mazeInNode) {
        this.mazeInNode = mazeInNode;
    }

     ArrayList<Node> BBFS(Node start, Node end) {

        int distance = 0;
        int[] row = {0, 0, 1, -1};
        int[] col = {1, -1, 0, 0};
        int N = row.length;


        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        ArrayList<Node> shortestPathList = new ArrayList<>();
        Stack<Node> pathStack = new Stack<>();

        pathStack.add(start);
        q.add(start);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            //  int distance = node.distance;

            if (visited.get(node) == null) {
                visited.put(node, true);
                if (node.getX() == end.getX() && node.getY() == end.getY()) {

                    Node node2, currentSrc = end;
                    //  shortestPathList.add(end);
                    while (!pathStack.isEmpty()) {
                        node2 = pathStack.pop();
                        if (isNeighbor(node2, currentSrc)) {
                            if (node2 == start)
                                break;
                            shortestPathList.add(node2);
                            currentSrc = node2;

                        }
                    }

                  //  System.out.println(shortestPathList);
                return shortestPathList;
                   // return distance;
                }
                for (int i = 0; i < N; i++) {
                    if (valid(x + row[i], y + col[i])) {
                        Node temp = new Node(x + row[i], y + col[i]);//, distance + 1);


                        temp.Neightbourd.add(node);
                        node.Neightbourd.add(temp);
                        q.add(temp);
                        pathStack.add(temp);
                    }
                }
                distance++;
            }
        }

        return null;
    }
    private boolean valid(int i, int i1) {
        if (mazeInNode.contains(new Node(i, i1))) {
            return true;
        }
        return false;
    }

    private boolean isNeighbor(Node x, Node y) {
        for (Node iterator : x.Neightbourd) {
            if (iterator.getX() == y.getX() && iterator.getY() == y.getY()) {
                return true;
            }
        }
        return false;

    }
}
