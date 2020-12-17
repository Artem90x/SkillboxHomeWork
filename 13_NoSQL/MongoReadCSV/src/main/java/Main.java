

public class Main {

    public static void main(String[] args) {
        MongoConfig mongoConfig = new MongoConfig();
        mongoConfig.init();

        Parser parser = new Parser(mongoConfig.getCollection());
        parser.parseCSV();
    }
}