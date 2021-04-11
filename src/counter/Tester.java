package counter;

import java.util.List;

public interface Tester<T> {
    void deleteElements(List<T> testCollection);
    void containsElements(List<T> testCollection);
}
