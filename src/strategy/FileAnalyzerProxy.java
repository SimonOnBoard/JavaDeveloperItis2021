package strategy;

import java.io.IOException;
import java.util.function.Consumer;

public class FileAnalyzerProxy implements FileAnalyzer {
    private FileAnalyzer target;

    public void setTarget(FileAnalyzer target) {
        this.target = target;
    }

    public void setBeforeMethodAdvice(Consumer<String> beforeMethodAdvice) {
        this.beforeMethodAdvice = beforeMethodAdvice;
    }

    private Consumer<String> beforeMethodAdvice;

    public void setAfterMethodAdvice(Consumer<String> afterMethodAdvice) {
        this.afterMethodAdvice = afterMethodAdvice;
    }

    private Consumer<String> afterMethodAdvice;


    @Override
    public FileInfo analyze(String filePath) throws IOException {
        beforeMethodAdvice.accept(filePath);
        try {
            return target.analyze(filePath);
        } finally {
            afterMethodAdvice.accept(filePath);
        }
    }
}
