package fastcampus.리스트;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private int size;
	private T[] elementData;

	public MyArrayList() {
		this.size = 0;
		this.elementData = (T[])new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.size = 0;
		this.elementData = (T[])new Object[capacity];
	}

	@Override
	public void add(T t) {
		if (this.size == this.elementData.length) {
			grow();
		}
		this.elementData[size++] = t;
	}

	private void grow() {
		this.elementData = Arrays.copyOf(this.elementData, getNewCapacity());
	}

	private int getNewCapacity() {
		return this.size + (this.size >> 1);
	}

	@Override
	public void insert(int index, T t) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
		}

		if (this.size == this.elementData.length) {
			grow();
		}

		for (int i = index; i < this.size; i++) {
			this.elementData[i + 1] = this.elementData[i];
		}
		this.elementData[index] = t;
		this.size++;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.elementData = (T[])new Object[DEFAULT_CAPACITY];
	}

	@Override
	public boolean delete(T t) {
		int index = -1;
		for (int i = 0; i < this.size; i++) {
			if (this.elementData.equals(t)) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			for (int j = index; j < this.size - 1; j++) {
				this.elementData[j] = this.elementData[j + 1];
			}
			this.elementData[--this.size] = null; // 삭제한 위치의 값을 null로 설정

			return true;
		}

		return false;
	}

	@Override
	public boolean deleteByIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
		}

		for (int i = index; i < this.size - 1; i++) {
			this.elementData[index] = this.elementData[index + 1];
		}
		this.elementData[--this.size] = null; // 삭제한 위치의 값을 null로 설정

		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException("리스트의 크기를 벗어난 인덱스입니다.");
		}

		return this.elementData[index];
	}

	@Override
	public int indexOf(T t) {
		for (int i = 0; i < this.size; i++) {
			if (this.elementData[i].equals(t)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(T t) {
		for (T el : this.elementData) {
			if (el.equals(t)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int size() {
		return this.size;
	}
}
