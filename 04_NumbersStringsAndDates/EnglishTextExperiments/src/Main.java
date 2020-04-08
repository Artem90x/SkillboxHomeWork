import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String enText = "The British isles are separated " +
                "from the European continent by the North Sea and the English Channel.";

        Pattern pattern = Pattern.compile("[^A-Za-zА-Яа-я]");
        String[] strings = pattern.split(enText);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
