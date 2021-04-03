package collections;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        String randomText = "Задача организации, в особенности же начало повседневной работы" +
                " по формированию позиции позволяет выполнить важнейшие задания по разработке модели развития! " +
                "Практический опыт показывает, что социально-экономическое развитие создаёт предпосылки качественно " +
                "новых шагов для системы масштабного изменения ряда параметров?" +
                " Равным образом постоянное информационно-техническое обеспечение " +
                "нашей деятельности представляет собой интересный эксперимент проверки " +
                "системы масштабного изменения ряда параметров.";
//
//        Map<Character, Integer> frequencyMap = getFrequencyOfTextCharacters(randomText);
//        System.out.println(frequencyMap);
//
//
//        List<String> listToClear = List.of("Павел", "Алексей", "Павел", "Иван", "Анна", "Евгений", "Анна");
//
//        Collection<String> clearedCollection = clearCollectionFromDuplicateElements(listToClear);
//
//        System.out.println(clearedCollection);

        testTimeOfDifferentListImplementations();


    }

    private static void testTimeOfDifferentListImplementations() {
        List<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerLinkedList = new LinkedList<>();
        Random random = new Random();
        int size = 1000000;
        int attemptCount = 100000;
        for (int i = 0; i < size; i++) {
            integerArrayList.add(random.nextInt(size));
            integerLinkedList.add(random.nextInt(size));
        }


        long timeStart = System.nanoTime();
        for (int i = 0; i < attemptCount; i++) {
            integerArrayList.get((int) (Math.random() * (size - 1)));
        }
        long endTime = System.nanoTime();
        System.out.println("For arrayList:" +  (endTime - timeStart));

        timeStart = System.nanoTime();
        for (int i = 0; i < attemptCount; i++) {
            integerLinkedList.get((int) (Math.random() * (size - 1)));
        }
        endTime = System.nanoTime();
        System.out.println("For linkedList:" + (endTime - timeStart));

    }

    static Collection<?> clearCollectionFromDuplicateElements(Collection<?> listToClear) {
        return new HashSet<>(listToClear);
    }

    static Map<Character, Integer> getFrequencyOfTextCharacters(String randomText) {
        randomText = randomText.toLowerCase();
        Integer pointer = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < randomText.length(); i++) {
            Character character = randomText.charAt(i);

            if ((pointer = resultMap.get(character)) != null) {
                resultMap.put(character, ++pointer);
            } else {
                resultMap.put(character, 1);
            }
        }
        return resultMap;
    }
}
