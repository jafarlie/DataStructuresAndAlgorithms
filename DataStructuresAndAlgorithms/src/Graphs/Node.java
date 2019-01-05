package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public boolean visited;
    List<Node> neighbours;

    public Node(int data){
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Node neighbour){
        this.neighbours.add(neighbour);
    }

    public List<Node> getNeighbours(){
        return this.neighbours;
    }

    public void setNeighbours(List<Node> neighbours){
        this.neighbours = neighbours;
    }
}
