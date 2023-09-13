import java.util.*;

public class ListsAndMaps {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<String>(); // declaration and creation of an ArrayList instance that implements List interface
        String friend;

        friend = "Qwerty";
        friends.add(friend);

        friend = "Asdfgh";
        friends.add(friend);

        friend = "Zxcvbn";
        friends.add(friend);

        System.out.println("# friends: " + friends.size());

        // for loop
        System.out.println("Friends List");
        for (int i = 0; i < friends.size(); i++) {
            System.out.println("   " + friends.get(i));
        }

        // for-each loop
        System.out.println("Friends List");
        for (String friendName : friends) {
            System.out.println("   " + friendName);
        }

        // iterator
        Iterator<String> friendIterator = friends.iterator();
        System.out.println("Friends List");
        while (friendIterator.hasNext()) {
            friend = friendIterator.next();
            System.out.println("   " + friend);
        }

        // List with primitive data types
        // we need a wrapper class of a primitive data type
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < 999999; i++) {
            // instead of using new Integer(i), we can use this
            // this is called boxing and unboxing
            integerList.add(i);
        }

        int sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
        }

        System.out.println("Sum: " + sum);

        // Map
        Map<String, String> table = new TreeMap<String, String>();

        table.put("CS0101", "Great course. Take it.");
        table.put("CS2300", "Nuh uh.");

        table.remove("CS2300");

        table.get("CS0101");

        table.containsKey("CS101");

        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
