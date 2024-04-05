package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.EditorModel;
import view.EditorView;

public class EditorController {
    private EditorView view;
    private EditorModel model;

    public EditorController(EditorView view, EditorModel model) {
        this.view = view;
        this.model = model;
    }

    public void handleView() {
        view.getNewItem().addActionListener(e -> {
            view.getTextArea().setText("");
        });

        view.getSaveItem().addActionListener(e -> {
            saveToFile();
        });
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.isDirectory()) {
                traverseDirectory(selectedFile);
            } else {
                saveFile(selectedFile);
            }
        }
    }

    private void traverseDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    traverseDirectory(file);
                } else {
                    saveFile(file);
                }
            }
        }
    }

    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(view.getTextArea().getText());
            JOptionPane.showMessageDialog(view, "File saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error occurred while saving file!");
        }
    }

    public static void main(String[] args) {
        EditorView view = new EditorView();
        EditorModel model = new EditorModel();
        new EditorController(view, model).handleView();
    }
}
