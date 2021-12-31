import java.util.ArrayList;
import java.util.List;

public class SimpleStringSet implements StringCollection{
    StringLinkedList head;
    StringLinkedList nextElement;

    public ArrayList<String> StringSet(){
        return(new ArrayList<String>());
    }

    public void addElements(ArrayList<String> array, StringCollection collection){
        // im guessing this meant to add the elements from the collection into the arraylist?
        List<String> elements = collection.toList();
        int j = 0;
        for(String i: elements) {
            String x = elements.get(j);
            array.add(x);
            j++;
        }
    }

    @Override
    public void add(String e) {
        StringLinkedList toAdd = new StringLinkedList(e);
        if (head == null) {
            head = toAdd;
            return;
        }
        StringLinkedList temp = head;
        while (temp.nextElement != null) {
            temp = temp.nextElement;
        }
        temp.nextElement = toAdd;
    }

    @Override
    public int getSize() {
        return (1 + nextElement.getSize());
    }

    @Override
    public boolean contains(String e) {
        StringLinkedList temp = head;
        StringLinkedList newString = new StringLinkedList(e);
        while (temp.nextElement != null) {
            if (temp == newString) {
                return (true);
            }
        }
        return (false);
    }

    @Override
    public boolean remove(String e) {
        StringLinkedList temp = head;
        StringLinkedList newString = new StringLinkedList(e);
        while (temp.nextElement != null) {
            if (temp == newString) {
                temp = temp.nextElement;
                return (true);
            }
        }
        return (false);
    }

    @Override
    public void addAllFromCollection(StringCollection collection) {
        StringLinkedList temp = head;
        List<String> elements = collection.toList();
        int j = 0;
        for(String i: elements) {
            String x = elements.get(j);
            temp.add(x);
            j++;
        }
    }

    @Override
    public List<String> toList() {
        ArrayList<String> elements = new ArrayList<String>();
        return elements;
    }
}
