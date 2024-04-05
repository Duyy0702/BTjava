package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditorView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JTextArea textArea;

    public EditorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 497);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu Menu = new JMenu("Menu");
        menuBar.add(Menu);
        
        newItem = new JMenuItem("New");
        Menu.add(newItem);
        
        saveItem = new JMenuItem("save");
        Menu.add(saveItem);
        
        JMenu edit = new JMenu("edit");
        menuBar.add(edit);
        
        JMenuBar menuBar_1 = new JMenuBar();
        menuBar.add(menuBar_1);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textArea = new JTextArea();
        textArea.setBounds(42, 47, 853, 403);
        contentPane.add(textArea);
        
        this.setVisible(true);
    }

    public JMenuItem getNewItem() {
        return newItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
