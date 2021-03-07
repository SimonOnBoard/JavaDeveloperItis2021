package strategy;

import java.time.LocalDateTime;

public class FileInfo {
    private int countOfPositions;
    private LocalDateTime openTime;
    private long  size;

    public FileInfo(int  countOfPositions, LocalDateTime openTime, long  size) {
        this.countOfPositions = countOfPositions;
        this.openTime = openTime;
        this.size = size;
    }

    public int getCountOfPositions() {
        return countOfPositions;
    }

    public void setCountOfPositions(int countOfPositions) {
        this.countOfPositions = countOfPositions;
    }

    public LocalDateTime getOpenInfo() {
        return openTime;
    }

    public void setOpenInfo(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "countOfPositions=" + countOfPositions +
                ", openTime=" + openTime +
                ", size=" + size +
                '}';
    }
}
