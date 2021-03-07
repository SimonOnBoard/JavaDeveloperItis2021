package strategy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        //настраиваем наш прокси
        FileAnalyzerProxyConfigurator fileAnalyzerProxyConfigurator = new FileAnalyzerProxyConfiguratorImpl();
        Consumer<String> beforeAdvice = filePath -> {
            System.out.println("Текущее дата и время: " + LocalDateTime.now());
            System.out.println("Существует такой файл: " + new File(filePath).exists());
        };

        Consumer<String> afterAdvice = filePath -> {
            System.out.println("Текущее дата и время: " + LocalDateTime.now());
        };
        FileAnalyzer target = new FileAnalyzerImpl();
        FileAnalyzer fileAnalyzerProxy = fileAnalyzerProxyConfigurator.configure(beforeAdvice, afterAdvice, target);


        //используем наш прокси как обычный file accessor
        FileStatisticsService fileStatisticsService = new FileStatisticsServiceImpl();
        fileStatisticsService.setStrategy(fileAnalyzerProxy);
        fileStatisticsService.makeFileInfoArray(new String[]{"/Users/simononboard/Desktop/stack.yml"});
        System.out.println(fileStatisticsService.getFileInfoList());
    }
}
