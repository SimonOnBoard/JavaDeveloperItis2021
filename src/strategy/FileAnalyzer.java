package strategy;

import java.io.IOException;

public interface FileAnalyzer {
    FileInfo analyze(String filePath) throws IOException;
}
