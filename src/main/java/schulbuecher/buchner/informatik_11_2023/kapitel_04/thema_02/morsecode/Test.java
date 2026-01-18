package schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_02.morsecode;

// Test
class Test
{
    Morsecode m = new Morsecode();

    Test()
    {
        System.out.println("Original: Informatik macht es möglich!");
        // Da nur kleine Buchstaben richtig analysiert werden und der Morsecode
        // keine Großbuchstaben
        // kennt
        // sollte der Text in "informatik ..." umgeändert werden!
        System.out.println(m.textZuMorsecode("informatik macht es möglich!"));
    }
}
