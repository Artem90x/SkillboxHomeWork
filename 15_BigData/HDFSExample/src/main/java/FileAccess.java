import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {

    private final FileSystem hdfs;

    /**
     * Initializes the class, using rootPath as "/" directory
     *
     * @param rootPath - the path to the root of HDFS,
     *                 for example, hdfs://localhost:32771
     */
    public FileAccess(String rootPath) throws Exception {

        Configuration configuration = new Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");
        System.setProperty("HADOOP_USER_NAME", "root");
        hdfs = FileSystem.get(new URI(rootPath), configuration);
    }

    /**
     * Creates empty file or directory
     *
     * @param path
     */
    public void create(String path) throws IOException {

        if (!hdfs.exists(new Path(path))) {
            try (OutputStream os = hdfs.create(new Path(path))) {
            }
        } else System.out.println("Файл уже существует");
    }

    /**
     * Appends content to the file
     *
     * @param path
     * @param content
     */
    public void append(String path, String content) throws IOException {

        Path fileForContent = new Path(path);
        try (FSDataOutputStream append = hdfs.append(fileForContent);
             BufferedWriter br = new BufferedWriter(new OutputStreamWriter(append, "UTF-8"))) {
            br.write("\n" + content);
        }
    }

    /**
     * Returns content of the file
     *
     * @param path
     * @return
     */
    public String read(String path) throws IOException {

        Path filePath = new Path(path);
        StringBuilder info = new StringBuilder();
        if (hdfs.exists(filePath)) {
            try (InputStream open = hdfs.open(filePath);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(open, "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    info.append(line).append("\n");
                }
            }
        } else System.out.println("Файл не найден");
        return info.toString();
    }

    /**
     * Deletes file or directory
     *
     * @param path
     */
    public void delete(String path) throws IOException {

        Path file = new Path(path);
        if (hdfs.exists(file)) {
            hdfs.delete(file, true);
        }
    }

    /**
     * Checks, is the "path" is directory or file
     *
     * @param path
     * @return
     */
    public boolean isDirectory(String path) throws IOException {
        return hdfs.isDirectory(new Path(path));
    }

    /**
     * Return the list of files and subdirectories on any directory
     *
     * @param path
     * @return
     */
    public List<String> list(String path) throws IOException {

        List<String> stringList = new ArrayList<>();
        if (hdfs.exists(new Path(path))) {
            FileStatus[] fileStatus = hdfs.listStatus(new Path(path));
            for (FileStatus status : fileStatus) {
                stringList.add(status.getPath().getName());
            }
        } else System.out.println("Файлы и папки не найдены");

        return stringList;
    }

    public void close() throws IOException {
        hdfs.close();
    }
}
