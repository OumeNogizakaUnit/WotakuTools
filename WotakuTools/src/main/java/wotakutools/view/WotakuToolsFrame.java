package wotakutools.view;

import javax.swing.JFrame;

import wotakutools.view.panel.MainPanel;

/**
 * メインとなる自作JFrame
 * @author shun kawai
 */
public class WotakuToolsFrame extends JFrame{
    private int width = 1000;
    private int height = 500;
    public WotakuToolsFrame(){
        super("WotakuTools");
        super.setBounds(100, 100, this.width, this.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel p = new MainPanel();
        super.add(p);

        super.setVisible(true);
    }
}