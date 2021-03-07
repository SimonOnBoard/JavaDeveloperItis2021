package strategy;

import java.io.IOException;
import java.util.List;

public interface FileStatisticsService {
    void makeFileInfoArray(String [] filePath) throws IOException;

    List<FileInfo> getFileInfoList();

    void setStrategy(FileAnalyzer fileAnalyzer);
}
