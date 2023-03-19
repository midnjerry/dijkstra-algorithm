package games.crusader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DijkstraShortestPath<Character> dsp = new DijkstraShortestPath<>();
        Node<Character>[] nodes = new Node[]{
                new Node<>('A'),
                new Node<>('B'),
                new Node<>('C'),
                new Node<>('D'),
                new Node<>('E'),
                new Node<>('F')};
        Integer[][] edges = {
                {null, 2, null, 8, null, null},
                {2, null, null, 5, 6, null},
                {null, null, null, null, 9, 3},
                {8, 5, null, null, 3, 2},
                {null, 6, 9, 3, null, 1},
                {null, null, 3, 2, 1, null}};
        List<Node> result = dsp.findShortestPath(0, 2, nodes, edges);

        System.out.println(result);
    }
}