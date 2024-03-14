package ua.ukma.kucherenko;

import java.util.Arrays;

public class PageRankCalculator {
    public double[] implementPageRank (double[][] adjacencyMatrix, double alpha) {
        int n = adjacencyMatrix.length;
        double[] pageRank = new double[n];
        Arrays.fill(pageRank, 1.0/n); // initialize all nodes with equal importance
        double[][] transitionProbabilityMatrix = getTransitionProbabilityMatrix(adjacencyMatrix, alpha);
        double[] previousPageRank;
        do {
            previousPageRank = pageRank.clone();
            pageRank = multiplyVectorByMatrix(previousPageRank, transitionProbabilityMatrix);
        } while (!converged(pageRank, previousPageRank));
        return pageRank;
    }

    public double[][] getTransitionProbabilityMatrix(double[][] adjacencyMatrix, double alpha) {
        int n = adjacencyMatrix.length;
        double[][] transitionProbabilityMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            int si = getOutDegree(adjacencyMatrix, i);
            if (si == 0) {
                Arrays.fill(transitionProbabilityMatrix[i], 1.0/n);
            } else {
                for (int j = 0; j < n; j++) {
                    transitionProbabilityMatrix[i][j] = alpha * adjacencyMatrix[i][j]/si + (1-alpha)/n;
                }
            }
        }
        return transitionProbabilityMatrix;
    }

    //find amount of connected pages with certain one
    public int getOutDegree(double[][] adjacencyMatrix, int node) {
        int outDegree = 0;
        for (int j = 0; j < adjacencyMatrix[node].length; j++) {
            outDegree += adjacencyMatrix[node][j];
        }
        return outDegree;
    }

    public double[] multiplyVectorByMatrix(double[] vector, double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (vector.length != m) {
            throw new IllegalArgumentException("Vector length must match matrix row dimension");
        }
        double[] result = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                result[j] += vector[i] * matrix[i][j];
            }
        }
        return result;
    }

    //find measure of iterating process
    public boolean converged(double[] pageRank, double[] previousPageRank) {
        double tolerance = Double.MIN_VALUE;
        for (int i = 0; i < pageRank.length; i++) {
            if (Math.abs(pageRank[i] - previousPageRank[i]) > tolerance) {
                return false;
            }
        }
        return true;
    }
}

