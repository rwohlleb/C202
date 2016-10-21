import java.util.*;

public class TestLinkedList
{
    public static void main(String[] args)
    {
        LinkedList<Integer> il = new LinkedList<>();
        il.add(5);
        il.add(17);
        il.addFirst(23);
        System.out.println(il.toString());
        System.out.println(il.remove());
    }
}