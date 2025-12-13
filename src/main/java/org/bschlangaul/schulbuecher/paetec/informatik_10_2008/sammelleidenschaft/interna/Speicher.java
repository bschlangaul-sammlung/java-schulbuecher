package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.sammelleidenschaft.interna;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Speicher
 *
 * @author Heuer
 */
public class Speicher<T> implements Iterable<T>
{
    /**
     * In der 10.Klasse nicht von Interesse
     */
    private HashSet<T> speicher = new HashSet<T>();

    /**
     * In der 10.Klasse nicht von Interesse
     */
    public HashSet<T> speicherGeben()
    {
        return speicher;
    }

    /**
     * In der 10.Klasse nicht von Interesse
     */
    public Iterator<T> iterator()
    {
        return speicher.iterator();
    }
}
