package operations;

import datastructures.linear.Stack;

public class StackOperations {

  public static void operations() {
    Stack<String> stack = new Stack<>();
    stack.push("Hello");
    stack.push("World");
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
