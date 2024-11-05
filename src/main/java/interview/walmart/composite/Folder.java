package interview.walmart.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {
    private List<FileSystem> fileSystemList;

    public Folder() {
        this.fileSystemList = new ArrayList<>();
    }

    public void addFile(FileSystem fileSystem) {
        this.fileSystemList.add(fileSystem);
    }

    @Override
    public void showDetails() {
        for (FileSystem file: this.fileSystemList) {
            file.showDetails();
        }
    }
}
