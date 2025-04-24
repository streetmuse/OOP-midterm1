import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
public class t1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(2);
        list1.add(8);
        list1.add(1);
        list1.add(3);
        list1.add(10);
        list1.add(6);
        list1.add(5);
        list1.add(4);
        list1.add(9);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("qmd");
        list2.add("vyj");
        list2.add("mgw");
        list2.add("bli");
        list2.add("hgn");
        list2.add("dhh");
        list2.add("uml");
        list2.add("seh");
        list2.add("xcv");
        list2.add("tar");
        list2.add("uhq");
        list2.add("zxj");

        ArrayList<String> list3 = new ArrayList<>();

        System.out.println("\n");
        System.out.println("list1\n");

        for (int i = 0; i < list1.size(); i ++) {
            System.out.println(i + "." +list1.get(i));
        }
        System.out.println("\n");
        System.out.println("list2\n");

        for ( int i = 0; i <list2.size(); i++) {
            System.out.println( i + "." +list2.get(i));
        }
        for (int i = 0; i < list1.size(); i++) {
            int position = list1.get(i);
            int index = position - 1; // Convert 1-based position to 0-based index
            if (index >= 0 && index < list2.size()) {
                list3.add(list2.get(index));
            } else {
                System.out.println("Invalid position: " + position);
            }
        }
        System.out.println("\n");
        System.out.println("list3\n");

        for (int i = 0; i < list3.size(); i++){
            System.out.println(i+"." +list3.get(i));
        }


    }

}
