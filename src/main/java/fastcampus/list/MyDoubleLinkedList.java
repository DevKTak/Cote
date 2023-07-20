package fastcampus.list;

// index 로 접근하는 메소드는 head 부터 찾을지 tail 부터 찾을지 분기처리 한다.
public class MyDoubleLinkedList<T> implements IList<T> {

    private int size;
    private Node head;
    private Node tail;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = tail;
        this.tail.prev = head;
    }

    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, this.tail);
        last.next = node;
        this.tail.prev = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        Node prev;
        Node curr;

        if (index < this.size / 2) {
            prev = this.head; /// insert 는 연결시켜주는 작업이 필요하므로 더미 노드부터 시작
            curr = prev.next;

            while (index-- > 0) {
                prev = curr;
                curr = curr.next;
            }
        } else {
            curr = this.tail;
            prev = curr.prev;

            while (index++ < this.size) {
                curr = prev;
                prev = curr.prev;
            }
        }
        Node node = new Node(t, prev, curr);
        prev.next = node;
        curr.prev = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Node prev;
        Node curr;

        if (index < this.size / 2) { // index 가 head 에서 더 가까운 경우
            prev = this.head;
            curr = prev.next;

            while (index-- > 0) {
                prev = curr;
                curr = curr.next;
            }
        } else {
            curr = this.tail;
            prev = curr.prev;

            while (index++ < this.size) {
                curr = prev;
                prev = curr.prev;
            }
        }
        prev.next = curr.next;
        curr.next.prev = prev;
        curr.prev = null;
        curr.next = null;
        this.size--;

        return true;
    }

    @Override
    public T get(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        Node curr;

        if (index < this.size / 2) { // index 가 head 에서 더 가까우면
            curr = this.head.next;

            while (index-- > 0) {
                curr = curr.next;
            }

        } else { // index 가 tail 에서 더 가까우면
            curr = this.tail.prev; // 연결작업이 필요없으므로 dummy 노드인 this.tail 부터 시작할 필요 없음

            while (index++ < this.size - 1) { // this.tail.prev 부터 시작하므로 -1
                curr = curr.prev;
            }

        }

        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        if (t == null) {
            throw new NullPointerException("검색할 값이 null 입니다.");
        }

        Node frontCurr = this.head.next;
        int hadex = 0;

        while (frontCurr.next != this.tail) {
            if (frontCurr.data.equals(t)) {
                return hadex;
            }
            frontCurr = frontCurr.next;
            hadex++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    @Override
    public boolean contains(T t) { // O(N) -> O(N/2)
        if (t == null) {
            throw new NullPointerException("검색할 값이 null 입니다.");
        }

        /// 한번 while 문을 실행시킬 때 마다 head 와 tail 에서 같이 찾아 들어간다.
        Node frontCurr = this.head.next;
        Node rearCurr = this.tail.prev;

        while (frontCurr != rearCurr && frontCurr.prev != rearCurr) {
            if (frontCurr.data.equals(t) || rearCurr.data.equals(t)) {
                return true;
            }
            frontCurr = frontCurr.next;
            rearCurr = rearCurr.prev;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private class Node {

        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
