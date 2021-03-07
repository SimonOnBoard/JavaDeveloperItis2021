package strategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStatisticsServiceImpl implements FileStatisticsService {
    private FileAnalyzer fileAnalyzer;
    private final List<FileInfo> fileInfoList;
    public FileStatisticsServiceImpl() {
        this.fileInfoList = new ArrayList<>();
    }

    @Override
    public void makeFileInfoArray(String[] listOfFilePath) throws IOException {
        if(fileAnalyzer == null) throw new IllegalStateException("Strategy was not set");
        for (String str: listOfFilePath){
            fileInfoList.add(fileAnalyzer.analyze(str));
        }
    }

    @Override
    public List<FileInfo> getFileInfoList(){
        return new ArrayList<>(fileInfoList);
    }

    @Override
    public void setStrategy(FileAnalyzer fileAnalyzer) {
        this.fileAnalyzer = fileAnalyzer;
    }
}
