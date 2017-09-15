package wotakutools.view.panel;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import wotakutools.view.panel.MainPanel.SwitchResuletCharaaniPanel;

/**
 * メインとなる自作パネル
 * @author shun kawai
 */
public class MainPanel extends JPanel{
    private SelectPanel sp;
    private ResultPanel rp;
    public MainPanel(){
        super();
        super.setBackground(Color.CYAN);
        super.setLayout(new GridLayout(1, 2));
        this.sp = new SelectPanel();
        this.rp = new ResultPanel();

        sp.addActionListenerCharaani(new SwitchResuletCharaaniPanel(this));
        sp.addActionListenerFortune(new SwitchResuletFortunePanel(this));
        super.add(this.sp);
        super.add(this.rp);

    }
    class SwitchResuletCharaaniPanel implements ActionListener {
        private MainPanel p;
        public SwitchResuletCharaaniPanel(MainPanel p){
            this.p = p;
        }
        public void actionPerformed(ActionEvent e){
            p.rp.switchCharaaniPanel();
        }
    }
    class SwitchResuletFortunePanel implements ActionListener {
        private MainPanel p;
        public SwitchResuletFortunePanel(MainPanel p){
            this.p = p;
        }
        public void actionPerformed(ActionEvent e){
            p.rp.switchFortunePanel();
        }
    }
}