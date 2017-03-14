package ru.itis.graph;

/**
 * 14.03.2017
 * MatrixGraph
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MatrixGraph {
    private final int MAX_VERTICES_COUNT = 5;

    private int matrix[][];

    // если вершина i была просмотрена, то visited[i] = true
    private boolean visited[];

    public MatrixGraph() {
        matrix = new int[MAX_VERTICES_COUNT][MAX_VERTICES_COUNT];
        visited = new boolean[MAX_VERTICES_COUNT];
    }

    public void addEdge(int vertexI, int vertexJ) {
        matrix[vertexI][vertexJ] = 1;
        matrix[vertexJ][vertexI] = 1;
    }

    public boolean hasEdge(int vertexI, int vertexJ) {
        return matrix[vertexI][vertexJ] == 1;
    }

    public void printGraph() {
        System.out.print("  ");

        for (int i = 0; i < MAX_VERTICES_COUNT; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < MAX_VERTICES_COUNT; i++) {
            System.out.print("_ ");
        }
        System.out.println();

        for (int i = 0; i < MAX_VERTICES_COUNT; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < MAX_VERTICES_COUNT; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // степень вершины - количество соседей
    public int vertexDegree(int vertex) {
        int degree = 0;
        for (int j = 0; j < MAX_VERTICES_COUNT; j++) {
            if (matrix[vertex][j] == 1) {
                degree++;
            }
        }
        return degree;
    }

    // получить массив соседей
    public int[] getNeighbors(int vertex) {
        int neighbors[] = new int[vertexDegree(vertex)];
        int neighborsCount = 0;
        for (int j = 0; j < MAX_VERTICES_COUNT; j++) {
            if (matrix[vertex][j] == 1) {
                neighbors[neighborsCount] = j;
                neighborsCount++;
            }
        }

        return neighbors;

    }

    // получить массив всех непросмотренных соседей
    public int[] getUnvisitedNeighbors(int vertex) {
        // берем всех соседей
        int allNeighbors[] = getNeighbors(vertex);
        // создаем массив для непросмотренных соседей
        int unvisitedNeighbors[] = new int[allNeighbors.length];
        int unvisitedNeighborsCount = 0;

        for (int i = 0; i < allNeighbors.length; i++) {
            if (!visited[allNeighbors[i]]) {
                unvisitedNeighbors[unvisitedNeighborsCount] = allNeighbors[i];
                unvisitedNeighborsCount++;
            }
        }

        int resultUnvisitedNeighbors[] = new int[unvisitedNeighborsCount];

        /*
        for (int i = 0; i <unvisitedNeighborsCount; i++) {
            resultUnvisitedNeighbors[i] = unvisitedNeighbors[i];
        }
        */
        System.arraycopy(unvisitedNeighbors, 0, resultUnvisitedNeighbors, 0, unvisitedNeighborsCount);
        return resultUnvisitedNeighbors;
    }

    public void visit(int vertex) {
        visited[vertex] = true;
    }
}
