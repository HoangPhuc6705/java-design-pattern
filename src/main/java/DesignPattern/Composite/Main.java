package DesignPattern.Composite;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("Main.java", 10);
        File file2 = new File("User.java", 11);
        File file3 = new File("Bird.java", 12);
        File file4 = new File("Controller.java", 9);
        File file5 = new File("Service.java", 8);
        Folder folder1 = new Folder("package");
        folder1.add(file1);
        folder1.add(file2);
        folder1.add(file3);
        folder1.add(file4);
        folder1.add(file5);
        Folder folder2 = new Folder("src");
        File file6 = new File("Application.java", 4);
        File file7 = new File("AuthDao.java", 4);
        File file8 = new File("Model.java", 4);
        File file9 = new File("SuperClasslist.java", 4);
        folder2.add(file6);
        folder2.add(file7);
        folder2.add(file8);
        folder2.add(file9);
        folder1.add(folder2);

        folder1.printInfo("");
        

    }
}
