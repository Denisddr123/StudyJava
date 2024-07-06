package laba8.SingleConnectedList;

public class SingleList {
    static  Node head;
    public static void main(String[] args) {
        createHeadList(11);
        System.out.println("Список построен способом с головы, в цикле: " + getList());
        createTailList(13);
        System.out.println("Список построен способом с хвоста, в цикле: " + getList());
        addFirst(new Node(34, null));
        System.out.println("Добавление элемента в начало списка: " + head);
        addLast(new Node(99, null));
        System.out.println("Добавление элемента в конец списка: " + head);
        insert(new Node(101, null), 0);
        System.out.println("Добавление элемента в указанное место: " + head);
        insert(new Node(101, null), 3);
        System.out.println("Добавление элемента в указанное место: " + head);
        RemoveFirst();
        System.out.println("Удаление элемента с начала списка: " + head);
        RemoveLast();
        System.out.println("Удаление элемента с конца списка: " + head);
        remove(5);
        System.out.println("Удаление элемента с заданным номером из списка: " + head);
        remove(0);
        System.out.println("Удаление элемента с заданным номером из списка: " + head);
        remove(15);
        System.out.println("Удаление элемента с заданным номером из списка: " + head);
        createHeadRec(20);
        System.out.println("Создание списка с использованием рекурсии, ввод с головы createHeadRec():\n " + head);
        head = null;
        createTailRec(10);
        System.out.println("Создание списка с использованием рекурсии, ввод с хвоста createTailRec():\n " + head);
        System.out.println("Метод toStringRec: " + head.toStringRec());
    }
    public static void createHeadList(int lenght) {
        head = new Node(0, null);
        Node tail = head;
        for (int i=0; i<lenght-1; i++) {
            tail.next = new Node(i+1, null);
            tail = tail.next;
        }
    }
    public static void createHeadRec(int lenght) {
        head = new Node(0, null);
        Node tail = head;
        tail.next = headRec(lenght-1, 0);
    }
    public static Node headRec(int lenght, int i) {
        Node node;
        i++;
        if (lenght == i) {
            return new Node(i, null);
        }
        node = new Node(i, headRec(lenght, i));
        return node;
    }
    public static void createTailRec(int lenght) {
        head = null;
        tailRec(lenght-1);
    }
    public static void tailRec(int lenght) {
        if (lenght == 0) {
            head = new Node(lenght, head);
        } else {
            head = new Node(lenght, head);
            tailRec(lenght-1);
        }
    }
    public static void createTailList(int lenght) {
        head = null;
        for (int i=lenght-1; i>=0; i--) {
            head = new Node(i, head);
        }
    }
    public static String getList() {
        Node ref = head;
        StringBuilder str = new StringBuilder();
        while (ref != null) {
            str.append(ref.value).append(" ");
            ref = ref.next;
        }
        return str.toString();
    }
    public static void addFirst(Node node) {
        node.next = head;
        head = node;
    }
    public static void addLast(Node node) {
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = node;
    }
    public static void insert(Node node, int i) {
        Node ref = head;
        int j=0;
        while (ref.next != null && j<(i-1)) {
            ref = ref.next;
            j++;
        }
        if (i==0) {
            node.next = ref;
            head = node;
        } else {
            node.next = ref.next;
            ref.next = node;
        }

    }
    public static void RemoveFirst() {
        head = head.next;
    }
    public static void RemoveLast() {
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }
    public static void remove(int i) {
        Node ref = head;
        int j=0;
        while (ref.next.next != null && j<(i-1)) {
            ref = ref.next;
            j++;
        }
        if (i==0) {
            RemoveFirst();
        } else {
            ref.next = ref.next.next;
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
    public String toString() {
        Node ref = next;
        StringBuilder str = new StringBuilder(value + " ");
        while (ref != null) {
            str.append(ref.value).append(" ");
            ref = ref.next;
        }
        return str.toString();
    }
    public String toStringRec() {
        String str ="";
        if (next == null) {
            return str + value;
        }
        return str + (value + " " + next.toStringRec());
    }
}