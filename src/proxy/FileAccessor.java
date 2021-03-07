package proxy;

import java.io.IOException;

public interface FileAccessor {
    void analyze(String filePath) throws IOException;
}
