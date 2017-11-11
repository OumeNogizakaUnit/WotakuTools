package wotakutools.view.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectCharaaniButton
    extends JButton
    implements ActionListener{
        public SelectCharaaniButton(){
            super();
            super.setText("Charaani Switch");
            super.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e){
            System.out.println("Pushed select charaani button");

        }

}