package ru.itis.graph;

/**
 * 14.03.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph();
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(4, 1);

        int vertex2Neighbors[] = graph.getNeighbors(2);

        graph.printGraph();

        for (int i = 0; i < vertex2Neighbors.length; i++) {
            System.out.print(vertex2Neighbors[i] + " ");
        }

        System.out.println();

        int unvisited[] = graph.getUnvisitedNeighbors(2);

        for (int i = 0; i < unvisited.length; i++) {
            System.out.print(unvisited[i] + " ");
        }

        graph.visit(3);

        System.out.println();
        unvisited = graph.getUnvisitedNeighbors(2);

        for (int i = 0; i < unvisited.length; i++) {
            System.out.print(unvisited[i] + " ");
        }

    }
}
