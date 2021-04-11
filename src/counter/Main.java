package counter;

import collections.RandomStringGenerator;

public class Main {

    public static void main(String[] args) {
        Generator<String> stringGenerator = new RandomStringGenerator();
        Tester<String> tester = new ListTesterImpl<>();
        TimeCountManager<String> timeCountManager = new TimeCountManagerCollectionImpl<>(stringGenerator, tester);
        timeCountManager.countTimeForCollections();
    }
}
