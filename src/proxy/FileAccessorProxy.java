package proxy;

import java.io.IOException;
import java.util.function.Consumer;

public class FileAccessorProxy implements FileAccessor{
    private final FileAccessor target;

    public FileAccessorProxy(FileAccessor fileAccessor) {
        this.target = fileAccessor;
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
    public void analyze(String filePath) throws IOException {
        beforeMethodAdvice.accept(filePath);
        target.analyze(filePath);
        afterMethodAdvice.accept(filePath);
    }
}
