package strategy;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public interface FileAnalyzerProxyConfigurator {
    final Consumer<String> defaultBeforeAdvice = filePath -> System.out.println(LocalDateTime.now());

    final Consumer<String> defaultAfterAdvice = filePath -> System.out.println(LocalDateTime.now());

    default FileAnalyzer configure(Consumer<String> beforeAdvice,
                           Consumer<String> afterAdvice,
                           FileAnalyzer targetObject) {
        createEmptyProxyClass();
        addTargetObject(targetObject);
        addBeforeAdvice(beforeAdvice != null ? beforeAdvice : defaultBeforeAdvice);
        addAfterAdvice(afterAdvice != null ? afterAdvice : defaultAfterAdvice);
        return getFileAnalyzer();
    }

    FileAnalyzer getFileAnalyzer();

    void addAfterAdvice(Consumer<String> stringConsumer);

    void addBeforeAdvice(Consumer<String> stringConsumer);

    void addTargetObject(FileAnalyzer targetObject);

    void createEmptyProxyClass();
}
