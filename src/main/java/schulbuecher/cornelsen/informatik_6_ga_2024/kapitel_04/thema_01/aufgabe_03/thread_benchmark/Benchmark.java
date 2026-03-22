package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_03.thread_benchmark;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Benchmark
{
    private static boolean istPrimzahl(int x)
    {
        if (x < 2)
        {
            return false;
        }
        if (x == 2)
        {
            return true;
        }
        int max = (int) (Math.ceil(Math.sqrt(x)));
        int i = 2;
        while (i <= max)
        {
            if (x % i == 0)
            {
                return false;
            }
            i += 1;
        }
        return true;
    }

    private static long summierePrimzahlenBis(int n)
    {
        long summe = 0;
        for (int i = 2; i < n; i++)
        {
            if (istPrimzahl(i))
            {
                summe += i;
            }
        }
        return summe;
    }

    public static void testStarten(int anzahlThreads)
            throws ExecutionException, InterruptedException
    {
        List<Integer> eingabewerte = new ArrayList<Integer>();
        for (int i = 0; i < 500; i++)
        {
            eingabewerte
                .add(ThreadLocalRandom.current().nextInt(100000, 1000001));
        }

        if (anzahlThreads > 0)
        {
            ForkJoinPool threadpool = new ForkJoinPool(anzahlThreads);
            long start_time = System.nanoTime();
            long sum = threadpool.submit(() -> eingabewerte.parallelStream()
                .map(x -> summierePrimzahlenBis(x))
                .reduce(0l, Long::sum)).get();
            threadpool.shutdown();
            double laufzeit = (System.nanoTime() - start_time) / 1000000000.0d;
            System.out.println("Anzahl Threads: " + anzahlThreads
                    + "\tLaufzeit: " + laufzeit + "s");

        }
    }
}
