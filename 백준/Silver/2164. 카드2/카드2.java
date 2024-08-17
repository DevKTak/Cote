import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2164
 * 
 * 2164 카드2
 * 
 * Queue가 따로 있음!
 */
public class Main {
   public static void main(String []args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
      
//      Queue2 queue = new Queue2();
      Queue<Integer> queue = new LinkedList<Integer>();
      
      for(int i = 0 ; i < n; i++) {
         queue.offer(i+1);
      }

      while(queue.size() != 1) {
         queue.poll();
         
         if(queue.size() == 1)
            break;
         
         int num = queue.poll();
         queue.offer(num);
      }
      
      System.out.println(queue.peek());
   }
}

class Queue2 {
    int size;
    Node headNode;
    
    Queue2() {
        this.size = 0;
        headNode = null;
    }
    
    int front() {
        if(headNode == null) {
            return -1;
        } else {
            return headNode.val;
        }
    }
    
    int back() {
        if(headNode == null) {
            return -1;
        } else {
            Node tmp = headNode;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            return tmp.val;
        }
    }
    
    int size() {
        return this.size;
    }
    
    void push(int num) {
        Node newNode = new Node(num);
        Node tmp = this.headNode;
        if(tmp == null) {
           this.headNode = newNode;
           this.size++;
           return;
        }
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        this.size++;
    }
    
    int pop() {
       if(headNode == null) {
          return -1;
       }
       
       Node tmp = this.headNode;
       this.headNode = tmp.next;
       this.size--;
       
       return tmp.val;
    }
    
    int empty() {
        if(size == 0) {
           return 1;
        } else {
           return 0;
        }
    }
    
    class Node {
        Node next;
        int val;
        
        Node(int val) {
            this.next = null;
            this.val = val;
        }
    }
}