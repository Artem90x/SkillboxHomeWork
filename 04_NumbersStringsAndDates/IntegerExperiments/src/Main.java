public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(222));
    }

    public static Integer sumDigits(Integer number) {
        //@TODO: write code here
        int sum = 0;
        Integer result = 0;

        while (sum < Integer.toString(number).length()) {
            result += (Integer.parseInt(String.valueOf(Integer.toString(number).charAt(sum))));
            sum++;
        }
        return result;
    }
}
