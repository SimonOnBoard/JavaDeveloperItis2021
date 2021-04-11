package counter;

import java.util.ArrayList;
import java.util.List;

public class ListTesterImpl<T> implements Tester<T> {
    @Override
    public void deleteElements(List<T> testCollection) {
        List<T> listToTest = new ArrayList<>(testCollection.subList(0, 10000));
        for (T value: listToTest){
            testCollection.remove(value);
        }
    }

    @Override
    public void containsElements(List<T> testCollection) {
        List<T> listToTest = testCollection.subList(0, 10000);
        for (T value: listToTest){
            testCollection.contains(value);
        }
    }
}
