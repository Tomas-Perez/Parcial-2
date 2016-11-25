package MercadoGroso.Comparators;

import MercadoGroso.MGPackage;

import java.util.Comparator;

public class IDComparator implements Comparator<MGPackage> {
    @Override
    public int compare(MGPackage o1, MGPackage o2) {
        return o1.getClientId() - o2.getClientId();
    }
}
