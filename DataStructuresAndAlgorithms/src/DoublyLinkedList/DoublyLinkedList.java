package DoublyLinkedList;

public class DoublyLinkedList {

    Node head;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAfter(Node givenNode, int data){
        if(givenNode == null){
            System.out.println("Given node can't be null");
            return;
        }
        Node newNode = new Node(data);
        if(givenNode.next == null){
            givenNode.next = newNode;
            newNode.next = null;
            newNode.prev = givenNode;
        }else{
            Node nextNodeOfGivenNode = givenNode.next;
            givenNode.next = newNode;
            newNode.prev = givenNode;
            newNode.next = nextNodeOfGivenNode;
            nextNodeOfGivenNode.prev = newNode;
        }
    }

    public void append(int data){
        Node newNode = new Node(data);
        Node lastNode = head;
        newNode.next = null;
        if(head == null){
            newNode.prev = null;
            this.head = newNode;
            return;
        }
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    public void insertBefore(Node givenNode, int data){
        if(givenNode == null){
            System.out.println("Given node can't be null");
            return;
        }
        Node newNode = new Node(data);
        Node previousNodeOfGivenNode = givenNode.prev;
        if(previousNodeOfGivenNode == null){
            this.head = newNode;
            this.head.next = givenNode;
            givenNode.prev = newNode;
        }
        previousNodeOfGivenNode.next = newNode;
        newNode.next = givenNode;
        newNode.prev = previousNodeOfGivenNode;
    }

    public void printList(Node node){
        Node lst = null;
        while(node.next != null){
            System.out.print(node.value + "->");
            lst = node;
            node = node.next;
        }
        System.out.println(node.value);
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);


        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.push(7);


        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.append(4);


        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, 8);

        System.out.println("Created DLL is: ");


        dll.printList(dll.head);

    }
}
