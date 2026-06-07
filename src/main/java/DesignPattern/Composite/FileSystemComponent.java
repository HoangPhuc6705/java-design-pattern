package DesignPattern.Composite;

public abstract class FileSystemComponent {
    public abstract String getName();
    public abstract long getSize();
    public abstract void printInfo(String indent);
}
