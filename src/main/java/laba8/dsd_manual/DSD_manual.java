package laba8.dsd_manual;

public class DSD_manual {
    public static void main(String[] args) {
        Node node0 = new Node(0, null); // 0-й узел – будет головой в списке
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null); // последний узел – будет хвостом в списке

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0; // для перемещения по списку достаточно помнить голову
        while (ref != null) {
            System.out.print(" " + ref.value);
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
