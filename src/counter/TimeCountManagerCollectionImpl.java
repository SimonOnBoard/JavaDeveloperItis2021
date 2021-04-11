package counter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TimeCountManagerCollectionImpl<T> implements TimeCountManager<T> {
    private Generator<T> generator;
    private Tester<T> tester;
    public TimeCountManagerCollectionImpl(Generator<T> generator, Tester<T> tester) {
        this.generator = generator;
        this.tester = tester;
    }

    @Override
    public List<List<T>> createEmptyLists() {
        List<List<T>> result = new ArrayList<>();
        result.add(new LinkedList<>());
        result.add(new ArrayList<>());
        return result;
    }

    @Override
    public void countOperationsTime(List<List<T>> listToTest) {
        long start;
        long middle;
        long end;
        for (List<T> list: listToTest){
            start = System.nanoTime();
            tester.containsElements(list);
            middle = System.nanoTime();
            tester.deleteElements(list);
            end = System.nanoTime();
            System.out.println("For " + list.hashCode() + " contains operation cost: " + (middle - start));
            System.out.println("For " + list.hashCode() + " delete operation cost: " + (end - middle));

        }
    }

    @Override
    public void fillLists(List<List<T>> listToTest) {
        for (List<T> list : listToTest) {
            for (int i = 0; i < size; i++) {
                list.add(generator.next());
            }
        }
    }
}
