package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent{

    private String name;
    private List<FileSystemComponent> components;

    public Folder(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void add(FileSystemComponent file) {
        components.add(file);
    }

    public void remove(FileSystemComponent file) {
        components.remove(file);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getSize() {
        return components.stream().mapToLong(FileSystemComponent::getSize).sum();
    }

    @Override
    public void printInfo(String indent) {
        System.out.println(indent + name + "/");
        components.forEach(c -> {
            c.printInfo(indent + "    ");
        });
    }
}
