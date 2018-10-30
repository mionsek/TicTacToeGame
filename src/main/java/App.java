import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel panel = new JPanel();
    private Button buttons[] = new Button[9];
    private JButton NewGameButton;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        super("Tic Tac Toe App");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(null);
        createButtons();

        add(panel);
        setVisible(true);
    }

    private void createButtons() {
        final int constPos = 100;
        final int margin = 40;

        int x = 0, y = 0;
        for (int i = 0; i < 9; i++){
            this.buttons[i] = new Button();
            this.buttons[i].setBounds(x * constPos + margin, y *constPos + margin, constPos, constPos);
            this.panel.add(buttons[i]);
            x++;
            if(x%3 == 0){
                x = 0;
                y++;
            }
        }

        this.NewGameButton = new JButton("Nowa Gra");
        this.NewGameButton.setBounds(10, 10, 100 ,25);
        this.NewGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    System.out.println("Przycisk nr: " + i);
                    buttons[i].clearButton();
                }
            }
        } );
        this.panel.add(NewGameButton);
    }
}
