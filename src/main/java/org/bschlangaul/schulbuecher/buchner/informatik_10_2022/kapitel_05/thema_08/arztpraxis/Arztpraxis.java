package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_08.arztpraxis;

import java.util.ArrayList;

/**
 * Klasse zur Darstellung einer Arztpraxis mit einem Kinderarzt und zwei
 * Allgemeinärzten
 */
@SuppressWarnings("unused")
public class Arztpraxis
{

    private String name;

    private ArrayList<Patient> allgemeinarzt1;

    private ArrayList<Patient> allgemeinarzt2;

    private ArrayList<Patient> kinderarzt;

    public Arztpraxis()
    {
        name = "Dr. Hinkebein";
        kinderarzt = new ArrayList<Patient>();
        allgemeinarzt1 = new ArrayList<Patient>();
        allgemeinarzt2 = new ArrayList<Patient>();
    }

    public void anmelden(Patient p)
    {
        if (p.nenneAlter() < 14)
        {
            kinderarzt.add(p);
        }
        else if (allgemeinarzt1.size() < allgemeinarzt2.size())
        {
            allgemeinarzt1.add(p);
        }
        else
        {
            allgemeinarzt2.add(p);
        }
    }

    public void priorisieren(Patient p)
    {
        allgemeinarzt1.add(0, p);
    }

    public boolean istPraxisLeer()
    {
        return (kinderarzt.isEmpty() && allgemeinarzt1.isEmpty()
                && allgemeinarzt2.isEmpty());
    }
}
