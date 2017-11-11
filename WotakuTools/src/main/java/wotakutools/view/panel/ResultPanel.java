package wotakutools.view.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * 接続結果を表示するパネル
 * @author shun kawai
 */
public class ResultPanel extends JPanel{
    public ResultPanel (){
        super();
        super.setBackground(Color.BLACK);
        super.setBorder(new BevelBorder(10, Color.WHITE, Color.GRAY));
        this.setLayout(new GridLayout(1,1));

        this.switchCharaaniPanel();
    }
    public void switchCharaaniPanel(){
        System.out.println("Called switchCharaanPanel()");
        this.removeAll();
        this.add(new ResultCharaaniPanel());
        this.validate();
    }
    public void switchFortunePanel(){
        System.out.println("Called switchFortunePanel()");
        this.removeAll();
        this.add(new ResultFortunePanel());
        this.validate();
    }
}