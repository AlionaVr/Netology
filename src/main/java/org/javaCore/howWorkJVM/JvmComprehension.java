package org.javaCore.howWorkJVM;

public class JvmComprehension {
    /*    загрузка классов. ClassLoader-ы начинают работать, последовательно делегируют загрузку классов
        Application ClassLoader -> Platform ClassLoader -> Bootstrap ClassLoader
        1)  Bootstrap ClassLoader загружает все необходимые классы из java Base (java.util,java.lang ).  У нас это java.lang.Object, java.lang.Integer, java.lang.System).
        2) Platform ClassLoader загружает из Java SE (например, java.sql, но не в нашем случае:) )
        3) Application ClassLoader загружает наши классы. (JvmComprehension)

       класс JvmComprehension в Metaspace

       Далее стадия Linking, где проверяется валидность кода( байт-кода класса JvmComprehension),
       Связываются ссылки на другие классы, т.е.ссылка на Object o = new Object() преобразуется в прямую ссылку на класс java.lang.Object в памяти,
       поле out из java.lang.System получает ссылку на printStream

       После связывания идет инициализацияю Это включает выполнение всех статических блоков и инициализацию статических полей.
       Статические методы (main, printAll) подготавливаются, становятся доступными, помещаются в Metaspace

        JVM определяет main как точку входа в программу, открывает его фрейм в стеке.*/
    public static void main(String[] args) { //во фрейме main в стеке
        int i = 1;                      // 1  Переменная i создается в стеке, знавение 1 записывается туда же
        Object o = new Object();        // 2  в стеке переменная о  содержит ссылку  на объект в куче
        Integer ii = 2;                 // 3  Примитив 2 преобразуется в объект Integer и создается в куче, а ссылка ii в стеке
        printAll(o, i, ii);             // 4 Вызывается метод, открывается фрейм printAll в стеке, ссылки на o и ii, а также значение i передаются как аргументы.
        System.out.println("finished"); // 7  поле out класса System (в стеке) содержит ссылку на объект PrintStream в куче. Метод println в стеке открывается
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 После преобразовани в объект Integer, создается в куче, а ссылка ii в стеке
        System.out.println(o.toString() + i + ii);  // 6 поле out класса System (в стеке) содержит ссылку на объект PrintStream в куче.
        // Метод println в стеке открывается. toString() тоже в стеке.
    }
}
/* СБОРЩИК МУСОРА может удалить из памяти:
    1) uselessVar из кучи, после завершения метода printAll
    2) остальные только после завершения main...
 */

