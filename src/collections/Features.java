package collections;

import java.util.*;

public class Features {
    public static void main(String[] args) {
//        List<String> myList = new ArrayList<>(List.of( "Алексей", "Павел", "Иван", "Анна", "Евгений", "Анна"));
//        // TODO: 03.04.2021 - реализовать метод, который наполняет List рандомными строками
//        // TODO: 03.04.2021 - реализовать метод, который принимает на вход лист - возвращает пару чисел - индексы начала и конца середины списка
//
//        System.out.println(myList);
//
//        //Реализовать метод, который принимает на вход середину листа, считает частотный словарь символов
//        List<String> middle = myList.subList(2, 4);
//        Map<Character, Integer> frequencyMap = getFrequencyForList(middle);
//        System.out.println(middle);
//        System.out.println(frequencyMap);
//
//        //Напишите метод, удаляющий эту середину листа
//        middle.clear();
//        System.out.println(myList);
//
//        //Выясните, начинается ли List с 2 определённых элементов
//        List<String> listToCheck = new ArrayList<>(List.of("Алексей", "Павел"));
//        System.out.println(myList.subList(0,2).containsAll(listToCheck));

        //Найдите 100 минимальных значений из неотсортированного списка используя PriorityQueue
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++){
            integerList.add(random.nextInt(10000));
        }
        long time = System.nanoTime();
        List<Integer> minimalList = sortValuesByPriorityQueue(integerList, 100);
        minimalList.sort((integer, anotherInteger) -> integer.compareTo(anotherInteger));
        long endTime = System.currentTimeMillis();
        //System.out.println(time - endTime);

//        System.out.println(minimalList.stream().sorted().collect(Collectors.toList()));

        time = System.nanoTime();
        List<Integer> resultList = sortAllCollectionAndGetFirstNValues(integerList);
        endTime = System.currentTimeMillis();
        //System.out.println(time - endTime);

        //System.out.println(minimalList.containsAll(resultList));

    //        System.out.println(integerList.stream().limit(100).collect(Collectors.toList()));

        //Проверить наличие повторяющихся элементов в списке используя Set, не используя метода contains, equals, и итератор по списку
        //Все копии добавить в Map<?,?>, содержащий в качестве ключа сам элемент а в качестве значения количество этих элементов в списке
        Map<Integer, Integer> keyCounterMap = new HashMap<>();
        Set<Integer> resultSet = new HashSet<>();
        //наличие повторяющихся элементов
        System.out.println(Tasks.clearCollectionFromDuplicateElements(resultList).size() != resultList.size());
        System.out.println(resultList);
        resultList.forEach((value) ->{
            //операция add вернёт на false (в интерфейсе set) если в коллекции уже содержится такой элемент
            if(resultSet.add(value)){
                keyCounterMap.put(value, 1);
            } else {
                Integer integer = keyCounterMap.get(value);
                keyCounterMap.put(value, ++integer);
            }
        });
        System.out.println(keyCounterMap);
        System.out.println(resultSet);


        //Развернуть Map (поменять местами ключ и значение)

        //У полученной map поменять местами значения у двух разных ключей

        //После этого удалить из неё все записи, в значениях которых будет меньше 3 элементов


    }

    private static List<Integer> sortAllCollectionAndGetFirstNValues(List<Integer> integerList) {
        integerList.sort((val1, val2) -> val1.compareTo(val2));
        return integerList.subList(0, 100);
    }

    private static List<Integer> sortValuesByPriorityQueue(List<Integer> integerList, int count) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer: integerList){
            if(priorityQueue.size() < count){
                //наполняем пока у нас в очереди не станет необходимое количество элементов
                priorityQueue.add(integer);
                //если у нас самых верхний элемент (например тот который сейчас должен зайти к врачу)
                //больше чем тот которые мы хотим добавить
            } else if(priorityQueue.peek().compareTo(integer) > 0){
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
        Integer pointer = null;
        Map<Character, Integer> resultMap = new HashMap<>();
        for (String string: stringList){
            Map<Character, Integer> currentMap = Tasks.getFrequencyOfTextCharacters(string);
            for (Map.Entry<Character,Integer> keyValuePair: currentMap.entrySet()){
                if((pointer = resultMap.get(keyValuePair.getKey())) != null){
                    resultMap.put(keyValuePair.getKey(), pointer + keyValuePair.getValue());
                } else{
                    resultMap.put(keyValuePair.getKey(), keyValuePair.getValue());
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
