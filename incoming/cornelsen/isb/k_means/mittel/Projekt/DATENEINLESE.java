package schulbuecher.isb.k_means.mittel.Projekt;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import javax.swing.*;
import java.io.*;
import java.text.*;

public class DATENEINLESE
{

    /*
     * Hier kann man eine Datei öffnen, die Trainingsdaten enthält. Sie endet
     * mit .csv und muss sich im selben Verzeichnis, wie das BlueJ-Projekt
     * befinden.
     */
    public static PUNKT[] ladeTrainingsdaten(String Dateiname)
    {
        ArrayList<PUNKT> Datensatz = new ArrayList<PUNKT>();
        Datensatz.clear();
        File file = new File(Dateiname);
        if (!file.exists())
        {
            file = new File(Dateiname + ".csv");
            if (!file.exists())
            {
                JOptionPane.showMessageDialog(null,
                        "Die Datei mit dem Bezeichner " + Dateiname + "\n"
                                + "konnte nicht gefunden werden. Prüfen Sie, ob sich wirklich diese Datei\n"
                                + "in dem Verzeichnis befindet und ob auch die Endung stimmt.\n"
                                + "Üblicherweise lautet die Dateiendung .csv");
                return null;
            }
        }
        try (Scanner scanner = new Scanner(file))
        {
            scanner.nextLine();
            NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
            while (scanner.hasNextLine())
            {
                String zeile = scanner.nextLine();
                String[] tokens = zeile.split(";");

                String b = tokens[0];

                Number number = format.parse(tokens[1]);
                double x = number.doubleValue();

                number = format.parse(tokens[2]);
                double y = number.doubleValue();

                PUNKT d = new PUNKT(b, x, y);
                Datensatz.add(d);
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Die konnte leider nicht gelesen werden.");
        }

        JOptionPane.showMessageDialog(null, "Es wurden Trainingsdaten mit "
                + Datensatz.size() + " Datenpunkten eingelesen");

        PUNKT[] daten = new PUNKT[Datensatz.size()];
        Datensatz.toArray(daten);
        return daten;
    }
}
