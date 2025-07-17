import java.util.*;
import java.io.*;

class DocumentEditor {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor() {
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public void addImage(String image) {
        documentElements.add(image);
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : documentElements) {
                if (element.length() > 4 && 
                   (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    // any custom rendering logic of Image
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderedDocument);
            writer.close();
            System.out.println("Doument saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

public class DocumentEditorClient {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, world!");
        editor.addImage("image.jpg");
        editor.addText("This is a document editor.");
        String renderedDocument = editor.renderDocument();
        System.out.println("Rendered Document:\n" + renderedDocument);
        editor.saveToFile();
    }
}