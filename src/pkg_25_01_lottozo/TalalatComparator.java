package pkg_25_01_lottozo;

import java.util.Comparator;

public class TalalatComparator implements Comparator<Szelveny> {

    @Override
    public int compare(Szelveny egyik, Szelveny masik) {
        if (egyik.getTalalatokSzama() > masik.getTalalatokSzama()) {
            return -1;
        } else if (egyik.getTalalatokSzama() == masik.getTalalatokSzama()) {
            return 0;
        } else {
            return 1;
        }
    }

}
