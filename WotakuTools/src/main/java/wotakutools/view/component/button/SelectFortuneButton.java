package wotakutools.view.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectFortuneButton
    extends JButton
    implements ActionListener{
        public SelectFortuneButton(){
            super();
            super.setText("Fortune Switch");
            super.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e){
            System.out.println("Pushed select fortune button");

        }

}