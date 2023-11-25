package core;

import junit.framework.TestCase;

public class StackTestCases extends TestCase {

	// TC1
	public void testCreateNewEmptyStack() {
		Stack stack1 = new Stack(55);
		assertEquals(true, stack1.isEmpty());

		assertEquals(0, stack1.getSize());
	}

	// TC2
	public void testPushandTop() {
		Stack stack2 = new Stack(55);
		Object element = "test";
		try {
			stack2.push(element);
			assertEquals(false, stack2.isEmpty());
			assertEquals(element, stack2.top());
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// TC3
	public void testPushMustBeSameType() {
		Stack stack3 = new Stack(55);

		try {
			stack3.push(21);
			stack3.push(17);
			stack3.push(2546);
			assertEquals(false, stack3.isEmpty());
			assertEquals(2546, stack3.top());

			stack3.push("Stamp");
			fail("Expected exception not thrown");
		} catch (Exception e) {
			assertEquals("All elements in the stack must be of the same type", e.getMessage());
		}
	}

	// TC4
	public void testLIFO() {
		Stack stack4 = new Stack(55);
		try {
			stack4.push(1);
			stack4.push(2);
			assertEquals(2, stack4.top());
			assertEquals(2, stack4.pop());
			assertEquals(1, stack4.pop());
		} catch (Exception e) {
			fail("Unexpected exception: " + e.getMessage());
		}

	}

	// TC5
	public void testCapacity() {

		Stack stack5 = new Stack(3);
		try {
			stack5.push(1);
			stack5.push(2);
			stack5.push(3);
			stack5.push(4);
			fail("Element Overflow (Stack size 3 but can add 4 Element)");
		} catch (Exception e) {
			assertEquals("Stack is Full", e.getMessage());
		}
	}
}
