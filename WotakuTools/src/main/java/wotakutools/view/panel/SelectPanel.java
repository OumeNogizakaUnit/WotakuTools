package wotakutools.view.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import wotakutools.view.component.button.SelectCharaaniButton;
import wotakutools.view.component.button.SelectFortuneButton;

/**
 * fortuneかキャラアニかを選択するパネル
 * @author shun kawa
 */
public class SelectPanel extends JPanel{
    private SelectFortuneButton fb;
    private SelectCharaaniButton cb;
    public SelectPanel(){
        super();
        super.setBackground(Color.WHITE);
        super.setSize(200, 500);
        super.setBorder(new BevelBorder(10, Color.BLACK, Color.GRAY));
        this.cb = new SelectCharaaniButton();
        this.fb = new SelectFortuneButton();
        super.add(cb);
        super.add(fb);
    }
    public void addActionListenerCharaani(ActionListener e){
        this.cb.addActionListener(e);
    }
    public void addActionListenerFortune(ActionListener e){
        this.fb.addActionListener(e);
    }

}