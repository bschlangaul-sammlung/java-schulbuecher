package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2025;

public class Automat
{

    boolean prüfen(String lk)
    {
        if (lk.length() != 4)
        {
            return false;
        }
        char tmp = lk.charAt(0);

        if (tmp == 'A' || tmp == 'B' || tmp == 'C' || tmp == 'D')
        {
            if (lk.charAt(1) == '0' && lk.charAt(2) == '0')
                return false;
            if (lk.charAt(1) == '0' && lk.charAt(2) != '0')
                return false;

        }

        if (tmp == 'E' || tmp == 'F' || tmp == 'G' || tmp == 'H')
            if (lk.charAt(1) == '0' && lk.charAt(2) == '0')
                return false;
        tmp = lk.charAt(2);
        if (lk.charAt(1) == '1' && (tmp != '0' || tmp != '1' || tmp != '2'))
            return false;
        tmp = lk.charAt(3);
        // Syntax error on tokens, delete these tokensJava(1610612969)
        // if (tmp != { '1'} )

        if (tmp != '1' || tmp != '2' || tmp != '3' || tmp != '4' || tmp != '5'
                || tmp != '6')
            return false;

        return true;
    }

}
