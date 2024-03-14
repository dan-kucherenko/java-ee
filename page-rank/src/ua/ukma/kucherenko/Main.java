package ua.ukma.kucherenko;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1, 0},
        };
        double alpha = 0.85;
        PageRankCalculator pageRankCalculator = new PageRankCalculator();
        double[] pageRank = pageRankCalculator.implementPageRank(adjacencyMatrix, alpha);
        System.out.println("Below is an array of pageRanks of every given page" + '\n' + Arrays.toString(pageRank));
    }
}
