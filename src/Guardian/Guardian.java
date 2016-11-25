package Guardian;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Guardian<T> {
    private ArrayList<Predicate<T>> filters = new ArrayList<>();
    private ArrayList<T> elementsAllowed = new ArrayList<>();

    public Guardian() {
        filters.add(element -> true);
    }

    public boolean goThrough(T element){
        for (Predicate<T> predicate: filters) {
            if(!predicate.test(element)) return false;
        }
        elementsAllowed.add(element);
        return true;
    }

    public void addFilter(Predicate<T> predicate){
        filters.add(predicate);
    }

    public void removeFilter(Predicate<T> chosenPredicate){
        for(int i = 0; i<filters.size(); i++){
            if(filters.get(i).equals(chosenPredicate)) filters.remove(i);
        }
    }

    public ArrayList<T> getElementsAllowed() {
        return elementsAllowed;
    }
}
