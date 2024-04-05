package model;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class EditorModel {
    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JTextArea textArea;

    public JMenuItem getNewItem() {
        return newItem;
    }

    public void setNewItem(JMenuItem newItem) {
        this.newItem = newItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public void setSaveItem(JMenuItem saveItem) {
        this.saveItem = saveItem;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
