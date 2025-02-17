package org.javaCore.multithreadingSearchInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String[] texts = new String[25];
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("aab", 30_000);
        }

        long startTs = System.currentTimeMillis(); // start time

        for (String text : texts) {
            Future<Integer> future = executor.submit(() -> findMaxSize(text));
            futures.add(future);
        }
        int maxInterval = 0;
        for (Future<Integer> future : futures) {
            int result = future.get();
            maxInterval = Math.max(maxInterval, result);
        }

        executor.shutdown();//запрещает добавление новых задач в ExecutorService, не блокирует основоной поток
        executor.awaitTermination(1, TimeUnit.MINUTES);//ждем не более 1 минуты, пока все задачи завершатся.

        long endTs = System.currentTimeMillis(); // end time

        System.out.println("Max Interval: " + maxInterval);
        System.out.println("Time: " + (endTs - startTs) + "ms");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    private static int findMaxSize(String text) {
        int maxSize = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (i >= j) {
                    continue;
                }
                boolean bFound = false;
                for (int k = i; k < j; k++) {
                    if (text.charAt(k) == 'b') {
                        bFound = true;
                        break;
                    }
                }
                if (!bFound && maxSize < j - i) {
                    maxSize = j - i;
                }
            }
        }
        System.out.println(text.substring(0, 100) + " -> " + maxSize);
        return maxSize;
    }
}