
public class TextElement implements DocumentElement {
    private String text;
    
    public TextElement(String text) {
        this.text = text;
    }
    
    public void render() {
        System.out.println("Rendering text: " + text);
    }
    
}
