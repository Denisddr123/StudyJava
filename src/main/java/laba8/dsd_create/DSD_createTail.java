package laba8.dsd_create;
public class DSD_createTail {
    public static void main(String[] args) {
        System.out.println("Создание односвязного списка с хвоста.");
        Node head = null;
        for (int i=9; i>=0; i--) {
            head = new Node(i, head);
        }
        Node ref = head;
        while (ref != null) {
            System.out.println("значение = " + ref.value);
            ref = ref.next;
        }
    }
}
