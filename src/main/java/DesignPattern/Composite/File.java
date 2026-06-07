package DesignPattern.Composite;

public class File extends FileSystemComponent{

    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public void printInfo(String indent) {
        System.out.println(indent + this.name);
    }
}
