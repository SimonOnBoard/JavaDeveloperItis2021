package counter;

import java.util.List;

public interface TimeCountManager<T> {

    int size = 1000000;
    int bound = 10000;

    default void countTimeForCollections(){
        List<List<T>> listToTest =  createEmptyLists();
        fillLists(listToTest);
        countOperationsTime(listToTest);
    }

    List<List<T>> createEmptyLists();

    void countOperationsTime(List<List<T>> listToTest);

    void fillLists(List<List<T>> listToTest);

}
