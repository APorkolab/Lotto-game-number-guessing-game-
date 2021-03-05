package pkg_25_01_lottozo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Szelveny {

    Random rand = new Random();

    private String nev;
    private Set<Integer> tippek;
    private int talalatokSzama;
    private Set<Integer> nyeroSzamok = new HashSet<Integer>();

    public Szelveny(String nev, Set<Integer> tippek) {
        Set<Integer> ujHalmaz = new HashSet<>();
        try {
            if (!tippek.isEmpty() && tippek.size() == 3 && Collections.max(tippek) < 30 && Collections.min(tippek) > 1) {
                this.tippek = tippek;
            } else {
                this.tippek = ujHalmaz;
            }
        } catch (NullPointerException e) {
            this.tippek = ujHalmaz;
        }

        if (nev == null || nev.isEmpty() || nev.length() == 0) {
            this.nev = "Jatekos";
        } else {
            this.nev = nev;
        }

    }

    public void ertekel(Set<Integer> nyeroSzamok) {
        Set<Integer> eredmenySzam = new HashSet<>(nyeroSzamok);
        eredmenySzam.retainAll(tippek);
        talalatokSzama = eredmenySzam.size();
    }

    public String getNev() {
        return nev;

    }

    public Set<Integer> getTippek() {
        return tippek;
    }

    public Set<Integer> getNyeroSzamok() {
        for (int i = 1; i <= 3; i++) {
            int nyeroSzam = rand.nextInt(30) + 1;
            nyeroSzamok.add(nyeroSzam);
        }
        return nyeroSzamok;
    }

    public int getTalalatokSzama() {
        return talalatokSzama;
    }
}

