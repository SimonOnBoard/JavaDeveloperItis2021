package strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileAnalyzerImpl implements FileAnalyzer {
    @Override
    public FileInfo analyze(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return new FileInfo(fileInputStream.available(), LocalDateTime.now(), new File(filePath).getTotalSpace());
    }
}
