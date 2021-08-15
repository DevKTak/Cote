package utilTak;

import java.util.Arrays;

public class PriorityQueueTak {

  private int[] priorityArr;
  private int size;

  public PriorityQueueTak() {
    this(11);
  }

  public PriorityQueueTak(int arrSize) {
    this.priorityArr = new int[arrSize];
  }

  /**
   * 추가
   */
  public boolean addTak(int val) {
    if (this.size == this.priorityArr.length - 1) {
      arrSizeUpTak();
    }
    this.priorityArr[++this.size] = val;
    int childIndex = this.size;

    while (true) {
      int parent = this.priorityArr[childIndex / 2];
      int child = this.priorityArr[childIndex];

      if (parent > child) {
        int temp = parent;
        this.priorityArr[childIndex / 2] = child;
        this.priorityArr[childIndex] = temp;
        childIndex = childIndex / 2;
      } else {
        break;
      }
    }

    return true;
  }

  /**
   * 배열의 크기 증가
   */
  private void arrSizeUpTak() {
    int[] newArray = new int[this.priorityArr.length + 1];

    for (int i = 1; i < this.priorityArr.length; i++) {
      newArray[i] = this.priorityArr[i];
    }
    this.priorityArr = null;
    this.priorityArr = newArray;
  }

  /**
   * 삭제
   */
  public int pollTak() {
    int returnVal = this.priorityArr[1];
    this.priorityArr[1] = this.priorityArr[this.size];
    this.priorityArr[this.size] = 0;
    int parentIndex = 1;
    this.size--;

    while (parentIndex * 2 <= this.size) {
      int parentVal = this.priorityArr[parentIndex];
      int leftChildVal = this.priorityArr[parentIndex * 2];
      int rightChildVal = Integer.MAX_VALUE;

      if (parentIndex * 2 + 1 <= this.size) {
        rightChildVal = this.priorityArr[parentIndex * 2 + 1];
      }

      if (leftChildVal < rightChildVal) {
        if (leftChildVal < parentVal) {
          int temp = leftChildVal;
          this.priorityArr[parentIndex * 2] = parentVal;
          this.priorityArr[parentIndex] = temp;
          parentIndex = parentIndex * 2;
        } else {
          break;
        }
      } else {
        if (rightChildVal < parentVal) {
          int temp = rightChildVal;
          this.priorityArr[parentIndex * 2 + 1] = parentVal;
          this.priorityArr[parentIndex] = temp;
          parentIndex = parentIndex * 2 + 1;
        } else {
          break;
        }
      }
    }

    return returnVal;
  }

  /**
   * 최상위 노드 값 확인
   */
  public int peekTak() {
    return this.priorityArr[1];
  }

  /**
   * 배열의 크기 확인
   */
  public int getSizeTak() {
    return this.size;
  }

  /**
   * 배열이 비어있는지 확인
   */
  public boolean isEmptyTak() {
    return this.size == 0;
  }

  @Override
  public String toString() {
    return "PriorityQueueTak{" +
       "priorityArr=" + Arrays.toString(priorityArr) +
       ", size=" + size +
       '}';
  }
}

class testClass {

  public static void main(String[] args) {
    PriorityQueueTak pqt = new PriorityQueueTak();
    pqt.addTak(1);
    pqt.addTak(2);
    pqt.addTak(3);
    pqt.addTak(9);
    pqt.addTak(10);
    System.out.println(pqt.addTak(12));
    System.out.println(pqt.toString());

    System.out.println(pqt.peekTak());
    System.out.println(pqt.toString());

    System.out.println(pqt.pollTak());
    System.out.println(pqt.toString());

    System.out.println(pqt.getSizeTak());

    System.out.println(pqt.isEmptyTak());
  }
}
