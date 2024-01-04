package design.patterns.behavioral.momento.example1;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        EditorHistory history = new EditorHistory();

        editor.setContent("a");
        history.push(editor.createEditorState());

        editor.setContent("b");
        history.push(editor.createEditorState());

        editor.setContent("c");

        System.out.println(editor.getContent()); // "c"

        editor.restoreEditorState(history.pop());
        System.out.println(editor.getContent()); // "b" -> restored to previous state

        editor.restoreEditorState(history.pop());
        System.out.println(editor.getContent()); // "a" -> restored to previous state

    }
}
