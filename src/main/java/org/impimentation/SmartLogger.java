package org.impimentation;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    static int counter = 0;

    @Override
    public void log(String msg) {
        counter++;
        String info = "INFO# ";
        if (msg.toLowerCase().contains("error")) {
            info = "ERROR# ";
        }
        System.out.println(info + counter + ' ' + LocalDateTime.now() + msg);
    }
}
