package estructurales.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public void show(String indent) {
        System.out.println(indent + "+ Carpeta: " + name);
        for (FileSystemItem item : items) {
            item.show(indent + "   ");
        }
    }
}

