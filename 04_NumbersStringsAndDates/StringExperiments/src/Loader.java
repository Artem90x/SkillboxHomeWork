
public class Loader {

    public static void main(String[] args) {

        for (char i = 'A'; i <= 'Z'; i++) {
            int code = i;
            System.out.println(i + " :" + code);
        }

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);
        int a = text.indexOf("Вася заработал");
        int b = text.indexOf("руб");
        String cutOffVasya = text.substring(a + 14, b).trim();

        int c = text.indexOf("Маша - ");
        int d = text.lastIndexOf("руб");
        String cutOffMasha = text.substring(c + 6, d).trim();

        int sum = Integer.parseInt(cutOffVasya) + Integer.parseInt(cutOffMasha);
        System.out.println("Сумма Васи и Маши: " + sum);
    }
}