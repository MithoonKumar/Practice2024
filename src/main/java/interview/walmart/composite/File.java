package interview.walmart.composite;

public class File implements FileSystem{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("The name of the file is " + this.name);
    }
}
