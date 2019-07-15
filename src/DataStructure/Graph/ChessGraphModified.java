package DataStructure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

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
            graph.printGraph();
            search(graph, graph.nodes[0], graph.nodes[size * size - 1]);
        }
    }

    private static void search(Graph graph, Graph.Node start, Graph.Node end) {
        if (start == null) return;
        visit(start);
        for (int i = 0; start.children != null && i < start.children.size(); i++) {
            search(graph, (Graph.Node) start.children.get(i), end);
        }
    }

    private static void visit(Graph.Node start) {
        sb.append(start.data + " -> ");
    }

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

        class Node<T> {
            public T data;
            public LinkedList<Node<T>> children;
        }
    }
}
