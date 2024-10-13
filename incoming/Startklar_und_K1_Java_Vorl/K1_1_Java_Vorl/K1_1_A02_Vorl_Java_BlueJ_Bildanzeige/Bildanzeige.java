import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bildanzeige extends JFrame implements ActionListener 
{

    private JLabel label;
    private JButton button;
    private ImageIcon image;

    //Hier werden zwei einzelne Bilder verwaltet. Ersetzen durch Warteschlange!
    private Bild bild1;
    private Bild bild2;

    Bildanzeige() 
    {
        setTitle("Bildanzeige");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Hier ersetzen durch Warteschlange mit Bildern
        bild1=new Bild("bild1.jpg");
        bild2=new Bild("bild2.jpg");

        // Erstelle das Label mit dem ersten Bild
        // Stattdessen müsste das erste Bild aus der Warteschlange geholt werden. 
        String name = bild1.NameGeben();
        image = new ImageIcon(name);
        label = new JLabel(image);
        add(label, BorderLayout.CENTER);

        // Erstelle den Button und füge ihn zum Frame hinzu
        button = new JButton("Bild wechseln");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Methode, die aufgerufen wird, wenn der Button gedrückt wird
    public void actionPerformed(ActionEvent event) 
    {
        if (event.getSource() == button) 
        {
            // Ersetze das erste Bild durch das zweite Bild
            // Stattdessen müsste das nächste Bild aus der Warteschlange geholt werden.
            Bild nächstes = bild2;
            String name = nächstes.NameGeben();
            image = new ImageIcon(name);
            label.setIcon(image);

        }
    }

    public static void main(String[] args) 
    {
        new Bildanzeige();
    }
}