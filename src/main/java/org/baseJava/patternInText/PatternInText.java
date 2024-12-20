package org.baseJava.patternInText;
//        Ваша задача - найти какое количество раз текст в PATTERN повторяется в TEXT. Повторения могут пересекаться друг с другом.
//        предлагаем циклом перебрать все возможные позиции в TEXT в которых может начинаться PATTERN.
//        При переборе каждую позицию проверять циклом, перебирая символы в PATTERN и символы, которые идут начиная с перебираемой позиции.
//        Если при проверке хотя бы один из символов не совпадёт - позиция не подходит и переходим к следующей. В противном случае нужно увеличить счётчик повторений count.

public class PatternInText {
    private final String TEXT;
    private final String PATTERN;


    public PatternInText(String text, String pattern) {
        this.TEXT = text;
        this.PATTERN = pattern;
    }


    public int findPattern() {
        int count = 0;
        if (!PATTERN.isEmpty()) {
            for (int i = 0; i <= TEXT.length() - PATTERN.length(); i++) {
                boolean match = true;

                for (int j = 0; j < PATTERN.length(); j++) {
                    if (TEXT.charAt(i + j) != PATTERN.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            }
        }
        System.out.println("Строка " + PATTERN + " встретилась в тексте " + count + " раз");
        return count;
    }
}