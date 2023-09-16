package Ch10.Ch10Lvl3;

import java.util.*;

public class ThesaurusMain {
    public static void main(String[] args) {
        Thesaurus t = new Thesaurus();

        t.put("fast", "speedy");
        t.put("fast", "swift");
        t.put("fast", "quick");
        t.put("fast", "rapid");
        t.put("fast", "brisk");
        t.put("slow", "sluggish");
        t.put("slow", "slack");

        Set<String> synonymsFast = t.get("fast");
        Set<String> synonymsSlow = t.get("slow");
        Set<String> synonymsModerate = t.get("moderate");

        System.out.println(t.keys());
        System.out.println(synonymsFast);
        System.out.println(synonymsSlow);
        System.out.println(synonymsModerate);
    }
}

class Thesaurus {
    // data members
    private Map<String, Set<String>> wordMap;

    // constructors
    public Thesaurus() {
        wordMap = new HashMap<>();
    }

    // returns all synonyms of the word as a Set
    // returns null if there is no such word
    public Set<String> get(String word) {
        return wordMap.get(word);
    }

    // returns all keywords in this thesaurus as a Set
    // returns an empty set if there are no keys (if you
    public Set<String> keys() {
        return wordMap.keySet();
    }

    // adds 'synonym' to the synonym set of 'word'
    public void put (String word, String synonym) {
        Set<String> synonymSet = wordMap.get(word);
        if (synonymSet == null) {
            synonymSet = new HashSet<>();
            wordMap.put(word, synonymSet);
        }

        if (wordMap.containsKey(word)) {
            wordMap.get(word).add(synonym);
        }
    }
}