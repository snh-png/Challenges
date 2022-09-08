package DataStructure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ChessGraphModified {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(bufferedReader.readLine());
            Character[] inputArray = new Character[size * size];
            int index = inputArray.length - 1;
            for (int j = 0; j < size; j++) {
                String rowInputs = bufferedReader.readLine();
                String[] inputs = rowInputs.split(" ");
                for (int k = 0; k < inputs.length; k++) {
                    inputArray[index--] = inputs[k].charAt(0);
                }
            }
            Graph graph = new Graph(size * size, inputArray);
//            graph.printGraph();
//            graph.printAllPaths(graph.nodes[0], graph.nodes[size * size - 1]);
            graph.printMaxScoreAndPathCount(graph.nodes[0], graph.nodes[size * size - 1]);
        }
    }


//    private static void visit(Graph.Node start) {
//        sb.append(start.data + " -> ");
//    }

    static class Graph<T> {
        private int vertices;
        private Node<T>[] nodes;

        Graph(int vertices, T[] valueArr) {
            this.vertices = vertices;
            this.nodes = new Node[vertices];
            addEdges();
            populateNodes(valueArr);
        }

        private void addEdges() {
            int size = (int) Math.sqrt(vertices);
            for (int i = vertices - 1; i >= 0; i--) {
                nodes[i] = new Node<>();
                if (i == vertices - 1)
                    nodes[i].children = null;
                else if (i >= vertices - size) {
                    if (nodes[i].children == null) nodes[i].children = new LinkedList();
                    nodes[i].children.add(nodes[i + 1]);
                } else if ((i + 1) % size == 0) {
                    if (nodes[i].children == null) nodes[i].children = new LinkedList();
                    nodes[i].children.add(nodes[i + size]);
                } else {
                    if (nodes[i].children == null) nodes[i].children = new LinkedList();
                    nodes[i].children.add(nodes[i + size]);
                    nodes[i].children.add(nodes[i + 1]);
                    nodes[i].children.add(nodes[i + size + 1]);
                }
            }
        }

        private void populateNodes(T[] valueArr) {
            for (int i = 0; i < valueArr.length; i++) {
                nodes[i].data = valueArr[i];
            }
        }

        public void printGraph() {
            for (int i = 0; i < nodes.length; i++) {
                System.out.print(i + ": ");
                for (int j = 0; nodes[i].children != null && j < nodes[i].children.size(); j++) {
                    System.out.print(nodes[i].children.get(j).data + ", ");
                }

                System.out.println();
            }
        }

        public void printAllPaths(Graph.Node source, Graph.Node destination) {
            ArrayList<Graph.Node> pathList = new ArrayList<>();
            pathList.add(source);
            search(source, destination, pathList);
        }

        int maxScore;

        private void search(Node start, Node end, ArrayList<Graph.Node> pathList) {
            if (start.equals(end)) {
                int tempScore = 0;
                for (Node<Character> node : pathList) {
                    char score = node.data;
                    if (score >= '0' && score <= '9') {
                        tempScore += score;
                    }
                }
                if (tempScore > maxScore) maxScore = tempScore;
                System.out.println(pathList.stream().map(n -> n.toString()).collect(Collectors.joining(" -> ")));
                return;
            }
            for (int i = 0; start.children != null && i < start.children.size(); i++) {
                Node e = (Node) start.children.get(i);
                if (e.data.equals('x')) continue;
                pathList.add(e);
                search(e, end, pathList);
                pathList.remove(e);
            }
        }

        public void printMaxScoreAndPathCount(Node start, Node end) {
            ArrayList<Graph.Node> pathList = new ArrayList<>();
            pathList.add(start);
            search(start, end, pathList);
            System.out.println(maxScore);
        }

        class Node<T> {
            public T data;
            public LinkedList<Node<T>> children;

            @Override
            public String toString() {
                return String.valueOf(data);
            }
        }
    }
}
