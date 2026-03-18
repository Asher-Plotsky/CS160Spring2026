public class LegoLists {
    public static void main(String[] args) {
        System.out.println("Singly Linked List:");
        SinglyLinkedList sll = new SinglyLinkedList();
        Node newNode = new Node();
        newNode.data = 0;
        sll.head = newNode;
        sll.current = newNode;
        for (int i = 1; i <= 10; i++) {
            newNode = new Node();
            newNode.data = i;
            sll.current.next = newNode;
            sll.current = newNode;
        }
        sll.print();
        newNode = new Node();
        newNode.data = 11;
        sll.prepend(newNode);
        sll.print();
        newNode = new Node();
        newNode.data = 12;
        sll.append(newNode);
        sll.print();
        newNode = new Node();
        newNode.data = 13;
        sll.insertNodeAfter(7, newNode);
        sll.print();
        sll.removeFirst();
        sll.print();
        sll.removeLast();
        sll.print();
        System.out.println("Doubly Linked List:");
        DoublyLinkedList dll = new DoublyLinkedList();
        DoubleNode newNode2 = new DoubleNode();
        newNode2.data = 0;
        dll.head = newNode2;
        dll.current = newNode2;
        for (int i = 1; i <= 10; i++) {
            newNode2 = new DoubleNode();
            newNode2.data = i;
            dll.current.next = newNode2;
            dll.current = newNode2;
            dll.tail = newNode2;
        }
        dll.print();
        newNode2 = new DoubleNode();
        newNode2.data = 11;
        dll.append(newNode2);
        dll.print();
        newNode2 = new DoubleNode();
        newNode2.data = 11;
        dll.prepend(newNode2);
        dll.print();
        newNode2 = new DoubleNode();
        newNode2.data = 13;
        dll.insertNodeAfter(7, newNode2);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.removeLast();
        dll.print();
    }

}
class Node {
    int data;
    Node next;
}
class SinglyLinkedList{
    Node head;
    Node current;
    Node temp;
    public void append(Node node){
        if(head == null){
            head = node;
        }
        else{
            temp = head.next;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void prepend(Node node){
        if(head == null){
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
    }
    public void insertNodeAfter(int node, Node newNode){
        temp = head;
        while(temp.next != null){
            temp = temp.next;
            if (temp.data == node){
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
        }
    }
    public void removeFirst(){
        head = head.next;
    }
    public void removeLast(){
        temp = head;
        while(temp.next.next != null && temp.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void print(){
        temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;
}
class DoublyLinkedList{
    DoubleNode head;
    DoubleNode tail;
    DoubleNode current;
    DoubleNode temp;
    public void append(DoubleNode node){
        if(head == null){
            head = node;
            tail =  node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void prepend(DoubleNode node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    public void insertNodeAfter(int node, DoubleNode newNode){
        temp = head;
        while(temp.next != null){
            temp = temp.next;
            if (temp.data == node){
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next = newNode;
                if (newNode.next == null){
                    tail = newNode;
                }
                break;
            }
        }
    }
    public void removeFirst(){
        head = head.next;
        head.prev = null;
    }
    public void removeLast(){
        temp = tail;
        tail = tail.prev;
        temp.prev=null;
        tail.next = null;
    }
    public void print(){
        temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}