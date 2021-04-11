package collections;

import java.util.*;

public class Features {
    public static void main(String[] args) {
        resolveFirstPart();
        resolveSecondPart();
        var map = resolveThirdPart();
        System.out.println(map);
        //Развернуть Map (поменять местами ключ и значение)
        System.out.println("_______________________________________________");
        var newMap = reverseMap(map);
        System.out.println(newMap);
        //У полученной map поменять местами значения у двух разных ключей
        System.out.println("_______________________________________________");
        newMap.put(6, newMap.put(7, newMap.get(6)));
        System.out.println(newMap);
        //После этого удалить из неё все записи, в значениях которых будет меньше 3 элементов
        System.out.println("_______________________________________________");
        newMap.values().removeIf(value -> value.size() <= 3);
        System.out.println(newMap);
    }

    private static Map<Integer, Collection<Integer>> reverseMap(Map<Integer, Integer> map) {
        Map<Integer, Collection<Integer>> resultMap = new HashMap<>();
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer value = map.get(key);
            resultMap.compute(value, (valueToInsert, existingValue) -> {
                if (existingValue == null) {
                    existingValue = new HashSet<>();
                }
                existingValue.add(key);
                return existingValue;
            });
        }
        return resultMap;
    }

    private static Map<Integer, Integer> resolveThirdPart() {
        //Проверить наличие повторяющихся элементов в списке используя Set, не используя метода contains, equals, и итератор по списку
        //Все копии добавить в Map<?,?>, содержащий в качестве ключа сам элемент а в качестве значения количество этих элементов в списке
        Map<Integer, Integer> keyCounterMap = new HashMap<>();
        Set<Integer> resultSet = new HashSet<>();
        List<Integer> resultList = createRandomIntegerList(1000, 100);
        //наличие повторяющихся элементов - если коллекции не совпадают, значит удалось удалить неповторяющиеся элементы
        System.out.println(Tasks.clearCollectionFromDuplicateElements(resultList).size() != resultList.size());
        System.out.println(resultList);
        resultList.forEach((value) -> {
            //операция add вернёт false (в интерфейсе set) если в коллекции уже содержится такой элемент
            if (resultSet.add(value)) {
                keyCounterMap.put(value, 1);
            } else {
                Integer integer = keyCounterMap.get(value);
                keyCounterMap.put(value, ++integer);
            }
        });
        System.out.println(keyCounterMap);
        System.out.println(resultSet);

        return keyCounterMap;

    }

    private static void resolveSecondPart() {
        //Найдите 100 минимальных значений из неотсортированного списка используя PriorityQueue
        final int size = 1000000;
        final int bound = 10000;
        List<Integer> integerList = createRandomIntegerList(size, bound);


        final long startTime = System.nanoTime();
        List<Integer> minimalList = sortValuesByPriorityQueue(integerList, 100);
        minimalList.sort((integer, anotherInteger) -> integer.compareTo(anotherInteger));
        final long endTime = System.nanoTime();
        System.out.println("Result time of sorting by priorty Queue: " + (startTime - endTime));


        final long fullCollectionStartTime = System.nanoTime();
        List<Integer> resultList = sortAllCollectionAndGetFirstNValues(integerList);
        final long fullCollectionEndTime = System.nanoTime();
        System.out.println("Sort full collection and get first numbers" + (fullCollectionStartTime - fullCollectionEndTime));


        System.out.println("Collections are equal: " + minimalList.containsAll(resultList));
    }

    private static List<Integer> createRandomIntegerList(int size, int bound) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt(bound));
        }
        return integerList;
    }

    private static void resolveFirstPart() {
        final int size = 10;
        //first task
        List<String> randomStringList = getRandomStringList(size);
        //get middle indexes - with appropriate middle part size
        final int middlePartSize = 2;
        Integer[] indexArray = getMiddleIndexes(size, middlePartSize);
        System.out.println(randomStringList);
        //Реализовать метод, который принимает на вход середину листа, считает частотный словарь символов
        //Возвращает List наполненный ссылками на элементы из уже существующего=
        List<String> middlePartList = randomStringList.subList(2, 4);
        //Давайте обсудим чем map идейно отличается от Collection?
        Map<Character, Integer> frequencyMap = getFrequencyForList(middlePartList);
        System.out.println(frequencyMap);

        //Напишите метод, удаляющий эту середину листа
        middlePartList.clear();
        System.out.println(randomStringList);

        //Выясните, начинается ли List с 2 определённых элементов
        List<String> listToCheck = new ArrayList<>(List.of("Алексей", "Павел"));
        System.out.println(randomStringList.subList(0, 2).containsAll(listToCheck));
    }

    private static Integer[] getMiddleIndexes(int size, int middlePartSize) {
        int middleIndex = size / 2;
        if (middleIndex - middlePartSize < 0 || middleIndex + middlePartSize >= size)
            throw new IllegalArgumentException("Middle part size out of list indexes");
        return new Integer[]{middleIndex - middlePartSize, middleIndex + middlePartSize};
    }

    private static List<String> getRandomStringList(int size) {
        List<String> result = new ArrayList<>();
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator(30);
        for (int i = 0; i < size; i++) {
            result.add(randomStringGenerator.next());
        }
        return result;
    }

    private static List<Integer> sortAllCollectionAndGetFirstNValues(List<Integer> integerList) {
        integerList.sort(Integer::compareTo);
        return integerList.subList(0, 100);
    }

    private static List<Integer> sortValuesByPriorityQueue(List<Integer> integerList, int count) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : integerList) {
            if (priorityQueue.size() < count) {
                //наполняем пока у нас в очереди не станет необходимое количество элементов
                priorityQueue.add(integer);
                //если у нас самых верхний элемент (например тот который сейчас должен зайти к врачу)
                //больше чем тот которые мы хотим добавить
            } else if (priorityQueue.peek().compareTo(integer) > 0) {
                //удалим этот элемент (тот который больше)
                priorityQueue.poll();
                //добавим тот который меньше
                priorityQueue.add(integer);
            }
        }
        List<Integer> list = new ArrayList<>(priorityQueue);
        return list;
    }

    private static Map<Character, Integer> getFrequencyForList(List<String> stringList) {
        Integer currentFrequencyInResultMap = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (String string : stringList) {
            Map<Character, Integer> currentMap = Tasks.getFrequencyOfTextCharacters(string);
            for (Map.Entry<Character, Integer> keyValuePairFromLastString : currentMap.entrySet()) {
                currentFrequencyInResultMap = resultMap.get(keyValuePairFromLastString.getKey());
                if (currentFrequencyInResultMap != null) {
                    resultMap.put(keyValuePairFromLastString.getKey(), currentFrequencyInResultMap + keyValuePairFromLastString.getValue());
                } else {
                    resultMap.put(keyValuePairFromLastString.getKey(), keyValuePairFromLastString.getValue());
                }
            }
        }
        return resultMap;
    }

    private static List<String> getMiddleOfAnotherList(List<String> myList) {
        List<String> resultList = new ArrayList<>();
        for (int i = 2; i <= 4; i++) {
            resultList.add(myList.get(i));
        }
        return resultList;
    }

}
