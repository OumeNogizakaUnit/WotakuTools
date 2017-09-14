package wotakutools.view;

import javax.swing.JFrame;
import wotakutools.view.panel.MainPanel;

public class WotakuToolsFrame extends JFrame{
    private int width = 1000;
    private int height = 800;
    public WotakuToolsFrame(){
        super("WotakuTools");
        super.setBounds(100, 100, this.width, this.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel panel = new MainPanel();
        add(panel);

        super.setVisible(true);
    }
}