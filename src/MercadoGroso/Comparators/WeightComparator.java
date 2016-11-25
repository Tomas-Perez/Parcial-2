package MercadoGroso.Comparators;

import MercadoGroso.MGPackage;

import java.util.Comparator;

public class WeightComparator implements Comparator<MGPackage>{

    @Override
    public int compare(MGPackage o1, MGPackage o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
