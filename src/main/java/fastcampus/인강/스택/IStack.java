package fastcampus.인강.스택;

public interface IStack<T> {

	void push(T data);

	T pop();

	T peek();

	int size();
}
