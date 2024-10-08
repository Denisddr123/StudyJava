package laba8.dsd_create;

public class DSD_createHead {
    public static void main(String[] args) {
        System.out.println("Создание односвязного списка с головы.");
        Node head = new Node(0, null);
        Node tail = head;

        for (int i=0; i<9; i++) {
            tail.next = new Node(i+1, null);
            tail = tail.next;
        }

        Node ref = head;

        while (ref !=  null) {
            System.out.println("значение = " + ref.value);
            ref = ref.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}