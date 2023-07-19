package fastcampus.list;

public class MyLinkedList<T> implements IList<T> {

    private class Node {

        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null); // dummy head node
    }

    @Override
    public void add(T t) {
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(t);
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index < 0 || index > this.size) { // deleteByIndex()와 다름을 확인하시오.
            throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
        }

        Node prev = this.head;
        Node curr = prev.next;

        while (index-- > 0) {
            prev = curr;
            curr = prev.next;
        }
        Node node = new Node(t, curr); // 새로 들어오는 노드의 next 노드는 curr 노드
        prev.next = node; // 이전 노드의 next 노드는 새로 들어오는 노드
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node curr = prev.next;

        while (curr != null) {
            if (curr.data.equals(t)) {
                prev.next = curr.next;
                curr.next = null; // curr은 더 이상 참조하는 객체가 없기 때문에 gc에 의해 회수될 예정
                this.size--;

                return true;
            }
            prev = curr;
            curr = prev.next;
        }

        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
        }

        Node prev = this.head;
        Node curr = prev.next;

        while (index-- > 0) {
            prev = curr;
            curr = prev.next;
        }
        prev.next  = curr.next;
        curr.next = null;
        this.size--;

        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
        }

        // get()은 연결시켜주는 작업이 필요없기 때문에 prev가 필요없음, dummy 노드부터 시작할 필요도 없음
        Node curr = this.head.next;

        while (index-- > 0) {
            curr = curr.next;
        }

        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        Node curr = this.head.next;
        int hadex = 0; // 헬스인들은 index 대신 hdex 또는 hadex 변수명을 사용한다.

        while (curr.next != null) {
            if (curr.data.equals(t)) {
                return hadex;
            }
            curr = curr.next;
            hadex++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
//        return this.size == 0;
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;

        while (curr != null) {
            if (curr.data.equals(t)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
