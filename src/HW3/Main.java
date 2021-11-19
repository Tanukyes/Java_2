package HW3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"world", "dog", "cat", "rain", "rain", "public", "apple", "dog",
                "turtle", "cow", "paper", "sun", "unicorn", "unicorn" };

        // count all words
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

        //write uniq words
        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        Phonebook pb = new Phonebook();

        pb.add("Ivanov","89998765341");
        pb.add("Zhlobin","89543123421");
        pb.add("Kolesnikov","89998723451");
        pb.add("Zhlobin","89543123421");
        pb.add("Vanchenko","89768666923");
        pb.add("Ivanov","89998765341");

        System.out.println(pb.get("Ivanov"));
        System.out.println(pb.get("Zhlobin"));
        System.out.println(pb.get("Kolesnikov"));
        System.out.println(pb.get("Vanchenko"));
    }
}

class Phonebook {
    private Map<String, List<String>> phonebook_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (phonebook_hm.containsKey(surname)) {
            phone_number_list = phonebook_hm.get(surname);
            phone_number_list.add(phone_number);
            phonebook_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            phonebook_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return phonebook_hm.get(surname);
    }

}
