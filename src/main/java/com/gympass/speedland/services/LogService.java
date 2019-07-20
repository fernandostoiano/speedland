package com.gympass.speedland.services;

public class LogService {

    public void readLog() {

        String line = "23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275";

    }


    public static void main(String ...args) {

        LogService service = new LogService();

        service.readLog();
    }
}
