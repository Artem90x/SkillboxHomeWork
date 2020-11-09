package rabin_karp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RabinKarpExtended {

    private String text;
    private TreeMap<Integer, Integer> number2position;
    private final int maxPatternSize = 33;

    public RabinKarpExtended(String text) {
        this.text = text;
        createIndex();
    }

    public List<Integer> search(String query) {

        ArrayList<Integer> indices = new ArrayList<>();

        if (query.length() > maxPatternSize) {
            throw new IllegalArgumentException("Exceeds max pattern size");
        }
        if (query.length() > text.length()) {
            return indices;
        }

        String alphabetQuery = textToIndex(query);
        if (alphabetQuery == null) {
            return indices;
        }

        long patternL = Long.parseLong(alphabetQuery);

        for (int i = 0; i < text.length() - query.length() + 1; i++) {

            String textSubstring = textToIndex(text.substring(i, i + query.length()));
            assert textSubstring != null;
            long substringL = Long.parseLong(textSubstring);

            if (patternL == substringL) {
                indices.add(i);
            }
        }
        return indices;
    }

    private String textToIndex(String text) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : text.toCharArray()) {
            Integer index = number2position.getOrDefault((int) c, null);
            if (index == null) {
                System.out.println("Index not found");
                return null;
            }
            stringBuilder.append(index);
        }
        return stringBuilder.toString();
    }

    private void createIndex() {

        number2position = new TreeMap<>();
        int index = 0;

        for (char c : text.toCharArray()) {
            number2position.put((int) c, number2position.getOrDefault((int) c, index++));
        }
        if (number2position.size() > 10) {
            throw new IllegalArgumentException("Exceeded 10 characters");
        }
    }
}
