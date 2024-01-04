package design.patterns.behavioral.momento.example1;

public class Editor {
    private String content;

    public Editor() {
    }

    public EditorState createEditorState() {
        return new EditorState(content);
    }

    public void restoreEditorState(EditorState state) {
        this.content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
