import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener  {
    private ImageIcon X, O;
    private static int nextPlayer = 0;
    private boolean canBeChanged = true;

    public Button(){
        this.X = new ImageIcon(this.getClass().getResource("x.png"));
        this.O = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
    }

    public void clearButton(){
        this.setIcon(null);
        this.canBeChanged = true;
        System.out.println("Wyczyszczony");
    }

    public void actionPerformed(ActionEvent e) {
        if (!canBeChanged){
            return;
        }
        nextPlayer += 1;
        nextPlayer %= 2;
        System.out.println(nextPlayer);

        switch (nextPlayer) {
            case 0:
                setIcon(this.X);
                break;
            case 1:
                setIcon(this.O);
                break;
        }
        canBeChanged = false;
    }
}
