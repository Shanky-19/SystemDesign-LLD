package Lecture7.GoodDesign;

import java.io.*;
import java.util.*;


interface DocumentElement {
    public String render();
}

class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String render () {
        return ("Rendering text: " + text);
    }
}

class ImageElement implements DocumentElement {
    private String path;

    public ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render () {
        return ("Rendering image: " + path);
    }
}

// NewLineElement represents a line break in the document.
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// TabSpaceElement represents a tab space in the document.
class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

interface Persistence {
    public void save(String data);
}

class FilePersistance implements Persistence {
    @Override
    public void save(String data) {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(data);
            writer.close();
            System.out.println("Doument saved to document.txt");
        } catch (Exception e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// Placeholder DBStorage implementation
class DBPersistance implements Persistence {
    @Override
    public void save(String data) {
        // Save to DB
    }
}

// Document class responsible for holding a collection of elements
class Document {
    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    // Renders the document by concatenating the render output of all elements.
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}


// DocumentEditor class managing client interactions
class DocumentEditor {
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderDocument());
    }
}

// Client usage example
public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FilePersistance();

        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}
