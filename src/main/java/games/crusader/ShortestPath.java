package games.crusader;

import java.util.List;

public interface ShortestPath<T> {
    public List<Node> findShortestPath(int sourceIndex, int targetIndex, Node<T>[] nodes, Integer[][] edges);
}
