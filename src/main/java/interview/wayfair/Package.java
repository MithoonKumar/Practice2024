package interview.wayfair;

public class Package implements IPackage{
    private int id;
    private String name;
    private int weight;
    private int length;
    private int width;
    private int height;
    private Category category;

    public Package(int id, String name, int length, int weight, int width, int height) {
        if (length <= 0 || width <= 0 || height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Dimensions and weight must be positive");
        }
        this.id = id;
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.category = determineCategory();
    }

    private Category determineCategory() {
        Category category;
        if (this.height <= 30 && this.width <= 30 && this.length <= 30) {
            category = Category.SMALL;
        } else if (this.height <= 60 && this.width <= 60 && this.length <= 60) {
            category = Category.MEDIUM;
        } else {
            category = Category.LARGE;
        }
        return category;
    }

    public int getPackageId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public Category getCategory() {
        return this.category;
    }
}
