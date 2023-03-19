package games.crusader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BellmanFord<T> implements ShortestPath<T>{
    @Override
    public List<Node> findShortestPath(int sourceIndex, int targetIndex, Node<T>[] nodes, Integer[][] edges) {
        // Keep track of shortest distance between source and each node.  Track that here:
        int[] minDistancesFromSource = new int[nodes.length];
        // When minimumDistance is found for node, track its predecessor in shortestPath
        Integer[] previous = new Integer[nodes.length];
        // Track all visited and unvisited nodes - can't backtrack during search
        Set<Integer> visited = new HashSet<>();
        Set<Integer> unvisited = new HashSet<>();

        // Initialize variables
        for (int nodeIndex = 0; nodeIndex < nodes.length; nodeIndex++) {
            minDistancesFromSource[nodeIndex] = Integer.MAX_VALUE;
            previous[nodeIndex] = null;
            unvisited.add(nodeIndex);
        }
        minDistancesFromSource[sourceIndex] = 0;

        while (unvisited.size() > 0){
            int minDistance = Integer.MAX_VALUE;
            Integer nodeToEvaluate = -1;
            for (Integer nodeIndex: unvisited){
                if (unvisited.contains(nodeIndex) && minDistancesFromSource[nodeIndex] < minDistance) {
                    minDistance = minDistancesFromSource[nodeIndex];
                    nodeToEvaluate = nodeIndex;
                }
            }

            for (int i = 0; i < nodes.length; i++){
                if (edges[nodeToEvaluate][i] != null && !visited.contains(i)) {
                    int distance = minDistance + edges[nodeToEvaluate][i];
                    if (distance < minDistancesFromSource[i]){
                        minDistancesFromSource[i] = distance;
                        previous[i] = nodeToEvaluate;
                    }
                }
            }

            visited.add(nodeToEvaluate);
            unvisited.remove(nodeToEvaluate);
        }

        List<Node> shortestPath = new ArrayList<>();
        Integer current = targetIndex;
        while (current != null){
            shortestPath.add(0, nodes[current]);
            current = previous[current];
        }

        System.out.println("Minimum Distance: " + minDistancesFromSource[targetIndex]);
        return shortestPath;
    }
}
