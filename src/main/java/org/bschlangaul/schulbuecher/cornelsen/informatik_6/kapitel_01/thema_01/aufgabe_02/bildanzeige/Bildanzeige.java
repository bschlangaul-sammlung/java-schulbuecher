package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.bildanzeige;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bildanzeige extends JFrame implements ActionListener
{

    private JLabel label;

    private JButton button;

    private ImageIcon image;

    private Warteschlange warteschlange;

    public Bildanzeige()
    {
        setTitle("Bildanzeige");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        warteschlange = new Warteschlange();
        warteschlange.Einfügen(new Bild("bild1.jpg"));
        warteschlange.Einfügen(new Bild("bild2.jpg"));
        warteschlange.Einfügen(new Bild("bild3.jpg"));
        warteschlange.Einfügen(new Bild("bild4.jpg"));
        warteschlange.Einfügen(new Bild("bild5.jpg"));

        // Erstelle das Label mit dem ersten Bild
        String name = warteschlange.Entfernen().NameGeben();
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
            // Ersetze das erste Bild durch das nächste Bild
            Bild nächstes = warteschlange.Entfernen();
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
