package list;


public interface List extends Collection {
    /**
     * Получение элемента коллекции по индексу
     * @param index индекс элемента
     * @return элемент, размещенный под этим индексом. Если элемент не найден, возвращается -1.
     */
    int get(int index);

    /**
     * Удаляет элемент по заданному индексу
     * @param index индекс удаляемого элемента
     */
    void removeAt(int index);

    /**
     * Возвращает индекс элемента (первое вхождение)
     * @param element элемент
     * @return позиция элемента, либо -1, если элемент не обнаружен
     */
    int indexOf(int element);

    /**
     * Возвращает индекс элемента (последнее вхождение)
     * @param element элемент
     * @return позиция элемента, или -1, если элемент не найден
     */
    int lastIndexOf(int element);

    boolean containsFromIndex(int element, int index);
}
