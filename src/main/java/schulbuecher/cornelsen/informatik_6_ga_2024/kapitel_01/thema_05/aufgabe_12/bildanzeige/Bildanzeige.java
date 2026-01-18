package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_12.bildanzeige;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bildanzeige extends JFrame implements ActionListener
{

    private JLabel label;

    private JButton button;

    private ImageIcon image;

    private Liste liste;

    public Bildanzeige()
    {
        setTitle("Bildanzeige");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        liste = new Liste();
        liste.VorneEinfügen(new Bild("bild1.jpg"));
        liste.HintenEinfügen(new Bild("bild2.jpg"));
        liste.SortiertEinfügen(new Bild("bild3.jpg"));
        liste.VorneEinfügen(new Bild("bild4.jpg"));
        liste.HintenEinfügen(new Bild("bild5.jpg"));

        // Erstelle das Label mit dem ersten Bild
        String name = ((Bild) liste.AnfangEntfernen()).NameGeben();
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
            Bild nächstes = (Bild) liste.AnfangEntfernen();
            if (nächstes != null)
            {
                String name = nächstes.NameGeben();
                image = new ImageIcon(name);
                label.setIcon(image);
            }

        }
    }

    public static void main(String[] args)
    {
        new Bildanzeige();
    }
}
