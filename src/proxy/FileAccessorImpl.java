package proxy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileAccessorImpl implements FileAccessor {
    @Override
    public void analyze(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        System.out.println(fileInputStream.available());
    }
}
