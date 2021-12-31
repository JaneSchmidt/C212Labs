import java.util.*;

public class StringLinkedList implements StringCollection {
    StringLinkedList head;
    StringLinkedList nextElement;
    String value;
    String nextValue;

    public String getValue(){return(value);}
    public StringLinkedList getNextElement(){return(nextElement);}

    public StringLinkedList(String value) {
        this.value = value;
        StringLinkedList newString = new StringLinkedList(value);
        nextElement = null;
        head = newString;
    }

    public StringLinkedList(String value, String nextValue) {
        this.value = value;
        this.nextValue = nextValue;
        head = new StringLinkedList(value);
        nextElement = new StringLinkedList(nextValue);
        int size = 1;
    }

    public boolean isLastElementInList(){
        // idk what's supposed to do here
        return(true);
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
                temp = null;
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
