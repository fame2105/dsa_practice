package design.patterns.behavioral.momento.example1;

import java.util.Stack;

public class EditorHistory {
    Stack<EditorState> stack;

    public EditorHistory() {
        this.stack = new Stack<>();
    }

    public void push(EditorState state) {
        stack.push(state);
    }

    public EditorState pop() {
        return stack.pop();
    }
}
