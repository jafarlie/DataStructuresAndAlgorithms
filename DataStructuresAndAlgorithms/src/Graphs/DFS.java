package Graphs;

import java.util.List;
import java.util.Stack;

public class DFS {

    // Iterative implementation using stack data structure
    public void dfsStack(Node node){
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        node.visited = true;
        while(!stack.empty()){
            Node popedElement = stack.pop();
            System.out.println(popedElement.data + " ");
            List<Node> neighboursOfPopedElement = popedElement.getNeighbours();
            for(int i=0; i<neighboursOfPopedElement.size(); i++){
                Node n = neighboursOfPopedElement.get(i);
                if(n!= null && !n.visited){
                    stack.add(n);
                    n.visited = true;
                }
            }
        }
    }

    // recursive implementation
    public void dfdRecursive(Node root){
        System.out.println(root.data + " ");
        List<Node> neighbours = root.getNeighbours();
        root.visited = true;
        for(int i=0; i < neighbours.size(); i++){
            Node n = neighbours.get(i);
            if(n!= null && !n.visited){
                dfdRecursive(n);
            }
        }
    }


    public static void main(String[] args){
        Node node4 =new Node(4);
        Node node1 =new Node(1);
        Node node2 =new Node(2);
        Node node3 =new Node(3);
        Node node6 =new Node(6);
        Node node5 =new Node(5);
        Node node7 =new Node(7);

        node4.addNeighbours(node1);
        node4.addNeighbours(node2);
        node1.addNeighbours(node3);
        node2.addNeighbours(node1);
        node2.addNeighbours(node3);
        node2.addNeighbours(node6);
        node2.addNeighbours(node5);
        node3.addNeighbours(node6);
        node6.addNeighbours(node7);
        node5.addNeighbours(node7);

        DFS dfs = new DFS();

        // let's look at running time of dfs recursive
        long startTime = System.nanoTime();
        dfs.dfdRecursive(node4);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("The execution time using recursive method was: " + duration/1000000 + " milliseconds");
        System.out.println("=========================================");

        System.out.println("Now, let's use the stack implementation for dfs");
        node4.visited=false;
        node1.visited=false;
        node2.visited=false;
        node3.visited=false;
        node6.visited=false;
        node5.visited=false;
        node7.visited=false;

        long start = System.nanoTime();
        dfs.dfsStack(node4);
        long end = System.nanoTime();

        long durationStack = (start - end)/1000000;
        System.out.println("The execution time using stack-based method was: " + durationStack/1000000 + " milliseconds");
        System.out.println("Hence, guys avoid recursive method whenever u can, it eats ur ram :D");





    }
}