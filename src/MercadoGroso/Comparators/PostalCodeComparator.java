package MercadoGroso.Comparators;

import MercadoGroso.MGPackage;

import java.util.Comparator;

public class PostalCodeComparator implements Comparator<MGPackage> {

    @Override
    public int compare(MGPackage o1, MGPackage o2) {
        return o1.getPostalCode() - o2.getPostalCode();
    }
}
