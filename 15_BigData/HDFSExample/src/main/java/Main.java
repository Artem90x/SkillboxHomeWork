public class Main
{
    private static String text = "Пробный текст";
    private final static String HADOOP_CONNECTION = "hdfs://d93e5a349193:8020";

    public static void main(String[] args) throws Exception {

        String pathDirectory  = "hdfs://d93e5a349193:8020/test";
        String path  = "hdfs://d93e5a349193:8020/test/myFile.txt";

        FileAccess fileAccess = new FileAccess(HADOOP_CONNECTION);
        fileAccess.create(path);
        fileAccess.append(path, text);
        System.out.println(fileAccess.read(path));
        fileAccess.delete(path);

        System.out.println(fileAccess.isDirectory(pathDirectory));
        System.out.println(fileAccess.list(pathDirectory));
        fileAccess.close();
    }
}
