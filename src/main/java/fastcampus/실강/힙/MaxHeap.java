package fastcampus.실강.힙;

public class MaxHeap {

	public int[] heap;
	public int size;

	public MaxHeap(int length) {
		heap = new int[length];
		heap[0] = 1000000000;
		size = 0;
	}

	public void upHeap(int pos) {
		int tmp = heap[pos];
		while (heap[pos / 2] < tmp) {
			heap[pos] = heap[pos / 2];
			pos = pos / 2;
		}
		heap[pos] = tmp;
	}

	public void insert(int num) {
		heap[++size] = num;

		upHeap(size);
	}

	public void downHeap(int pos) {
		int tmp = heap[pos];

		while (pos <= size / 2) { // 부모가 있는 노드의 인덱스까지만 POS가 가야함
			int idx = pos * 2;

			if (idx < size && heap[idx] < heap[idx + 1]) {
				idx++;
			}
			if (tmp > heap[idx])
				break;
			heap[pos] = heap[idx];
			pos = idx;
		}
		heap[pos] = tmp;
	}

	public int get() {
		int tmp = heap[1];
		heap[1] = heap[size--]; // 종단 노드를 최상단으로 일단 옮김

		downHeap(1);

		return tmp;
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(100);
		mh.insert(10);
		mh.insert(5);
		mh.insert(8);
		mh.insert(15);
		mh.insert(3);
		mh.insert(12);

		for (int i = 1; i <= mh.size; i++) {
			System.out.print(mh.heap[i] + " ");
		}
		System.out.println();
		mh.insert(20);

		for (int i = 1; i <= mh.size; i++) {
			System.out.print(mh.heap[i] + " ");
		}
		System.out.println();
		System.out.println(mh.get());
		System.out.println(mh.get());

		for (int i = 1; i <= mh.size; i++) {
			System.out.print(mh.heap[i] + " ");
		}
	}
}
