package list;

import fastcampus.리스트.MyDoubleLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDoubleLinkedListTest {

	private MyDoubleLinkedList<Integer> list;

	@BeforeEach
	public void setUp() {
		list = new MyDoubleLinkedList<>();
	}

	@Test
	public void testAddAndGet() {
		list.add(10);
		list.add(20);
		list.add(30);

		assertEquals(3, list.size());
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
		assertEquals(30, list.get(2));
	}

	@Test
	public void testInsert() {
		list.add(10);
		list.add(20);
		list.add(30);

		list.insert(1, 15);

		assertEquals(4, list.size());
		assertEquals(10, list.get(0));
		assertEquals(15, list.get(1));
		assertEquals(20, list.get(2));
		assertEquals(30, list.get(3));
	}

	@Test
	public void testDeleteByIndex() {
		list.add(10);
		list.add(20);
		list.add(30);

		list.deleteByIndex(1);

		assertEquals(2, list.size());
		assertEquals(10, list.get(0));
		assertEquals(30, list.get(1));
	}

	@Test
	public void testContains() {
		list.add(10);
		list.add(20);
		list.add(30);

		assertThrows(NullPointerException.class, () -> list.contains(null));
		assertTrue(list.contains(20));
		assertFalse(list.contains(40));
	}

	@Test
	public void testIndexOf() {
		list.add(10);
		list.add(20);
		list.add(30);

		assertEquals(1, list.indexOf(20));
		assertEquals(-1, list.indexOf(40));
	}

	@Test
	public void testClear() {
		list.add(10);
		list.add(20);
		list.add(30);

		list.clear();

		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());

		list.add(10);

		assertFalse(list.isEmpty());
	}
}
