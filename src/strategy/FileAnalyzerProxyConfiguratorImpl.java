package strategy;

import java.util.function.Consumer;

public class FileAnalyzerProxyConfiguratorImpl implements FileAnalyzerProxyConfigurator {
    private FileAnalyzerProxy fileAnalyzerProxy;

    @Override
    public FileAnalyzer getFileAnalyzer() {
        return fileAnalyzerProxy;
    }

    @Override
    public void addAfterAdvice(Consumer<String> stringConsumer) {
        fileAnalyzerProxy.setAfterMethodAdvice(stringConsumer);
    }

    @Override
    public void addBeforeAdvice(Consumer<String> stringConsumer) {
        fileAnalyzerProxy.setBeforeMethodAdvice(stringConsumer);
    }

    @Override
    public void addTargetObject(FileAnalyzer targetObject) {
        fileAnalyzerProxy.setTarget(targetObject);
    }

    @Override
    public void createEmptyProxyClass() {
        fileAnalyzerProxy = new FileAnalyzerProxy();
    }
}
