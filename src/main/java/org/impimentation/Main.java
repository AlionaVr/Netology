package org.impimentation;

public class Main {
    public static void main(String[] args) {
        Logger simpleLogger = new SimpleLogger();
        Logger smartLogger = new SmartLogger();

        smartLogger.log(" it's a Error");
        smartLogger.log(" it's a error2, sorry");
        smartLogger.log(" message from smartLogger");

        simpleLogger.log(" message from simpleLogger");
    }
}
