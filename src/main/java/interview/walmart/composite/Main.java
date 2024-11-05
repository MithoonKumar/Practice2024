package interview.walmart.composite;

public class Main {

    public static void main(String[] args) {
        FileSystem file = new File("First file");
        FileSystem file1 = new File("Second file");
        Folder folder = new Folder();
        folder.addFile(file);
        folder.addFile(file1);
        folder.showDetails();
    }
}
