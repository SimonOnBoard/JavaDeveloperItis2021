package proxy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        //настраиваем наш прокси
        FileAccessor target = new FileAccessorImpl();
        FileAccessorProxy fileAccessorProxy = new FileAccessorProxy(target);
        fileAccessorProxy.setBeforeMethodAdvice(filePath -> {
            System.out.println("Текущее дата и время: " + LocalDateTime.now());
            System.out.println("Существует такой файл: " + new File(filePath).exists());
        });
        fileAccessorProxy.setAfterMethodAdvice(filePath -> {
            System.out.println("Текущее дата и время: " + LocalDateTime.now());
        });




        //используем наш прокси как обычный file accessor
        FileAccessor mainFileAccessor = fileAccessorProxy;
        mainFileAccessor.analyze("/Users/simononboard/Desktop/stack.yml");

    }
}
