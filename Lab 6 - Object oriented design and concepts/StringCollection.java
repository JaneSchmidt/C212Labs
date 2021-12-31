import java.util.*;

public interface StringCollection {
    int getSize();
    void add(String e);
    boolean contains(String e);
    boolean remove(String e);
    void addAllFromCollection(StringCollection collection);
    List<String>toList();
    }
