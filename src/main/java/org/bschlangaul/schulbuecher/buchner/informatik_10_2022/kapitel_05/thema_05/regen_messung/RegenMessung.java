package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_05.regen_messung;

public class RegenMessung
{
    String[] regenMonate;

    public RegenMessung()
    {
        regenMonate = new String[10];
        regenMonate[0] = "Februar";
        regenMonate[1] = "Mai";
        regenMonate[2] = "Juni";
        regenMonate[3] = "April";
        regenMonate[4] = "Februar";
        regenMonate[5] = "März";
        regenMonate[6] = "April";
        regenMonate[7] = "Mai";
        regenMonate[8] = "Juni";
        regenMonate[9] = "April";
    }

    public void nennenRegenMonate()
    {
        int index = 0;
        while (index < regenMonate.length)
        {
            System.out.println(regenMonate[index]);
            index = index + 1;
        }
    }

    public boolean pruefeBehauptung()
    {
        int i = 0;
        int anzahl = 0;
        while (i < 10)
        {
            if (regenMonate[i].equals("April"))
            {
                anzahl = anzahl + 1;
            }
            i = i + 1;
        }
        if (anzahl > 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
