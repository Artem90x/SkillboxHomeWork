
import java.io.PrintWriter;

public class Generator extends Thread {
    int regionCode;
    private PrintWriter writer;
    char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public Generator(int regionCode, String path) {
        this.regionCode = regionCode;
        try {
            writer = new PrintWriter(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int number = 1; number < 1000; number++) {
            StringBuilder buffer = new StringBuilder();
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        buffer.append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append("\n");
                    }
                }
            }
            writer.write(buffer.toString());
        }

        writer.flush();
        writer.close();
    }

    private static synchronized String padNumber(int number, int numberLength) {
        StringBuffer numberStr = new StringBuffer(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }
}