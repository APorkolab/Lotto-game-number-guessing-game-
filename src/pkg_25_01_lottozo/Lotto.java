package pkg_25_01_lottozo;

import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Lotto {

    private Set<Integer> nyeroSzamok = new HashSet<Integer>();
    private String nev;

    public static void main(String[] args) {
        Set<Integer> tippek = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String nev;
        int jatekos = 1;
        int tippszam = 1;
        System.out.printf("Kérem a(z) %d. játékos nevét, * karakter, ha nincs több! ", jatekos);
        nev = sc.nextLine();
        if (nev == null || nev.length() == 0 || nev.isEmpty()) {
            jatekos++;
        }
        if (nev.equals("*")) {
            System.out.print(
                    "Szeretnél még játszani? (i/n) ");
            String akarszJatszani = sc.nextLine();

            if (akarszJatszani.equals(
                    "n")) {
                return;

            } else if (akarszJatszani.equals(
                    "i")) {
                do {

                    try {
                        do {

                            System.out.printf("Kérem %s nevű játékos %d. tippjét! ", nev, tippszam);
                            int tipp = sc.nextInt();
                            if (tippek.contains(tipp)) {
                                System.out.println("Ez a szám már volt!");
                            } else if (tipp > 30 || tipp < 1) {
                                System.out.println("1 és 30 közötti számot kérek szépen!");
                            } else {
                                tippek.add(tipp);
                                tippszam++;
                            }

                        } while (tippszam <= 3);

                    } catch (InputMismatchException e) {
                        tippek = Collections.emptySet();
                        return;
                    }

                    Szelveny ujSzelveny = new Szelveny(nev, tippek);
                    System.out.println("A nyerő számok: " + ujSzelveny.getNyeroSzamok());

                    System.out.printf("%s tippjei:", nev);
                    System.out.print(ujSzelveny.getTippek());
                    System.out.printf(", ez %d találatot ért!\n", ujSzelveny.getTalalatokSzama());

                } while (nev.equals(
                        "*"));

            }
        }
    }
}
