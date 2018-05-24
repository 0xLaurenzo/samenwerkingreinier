package assignment.pkg13;

import java.io.File;
import java.io.IOException;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class FileFinder implements Runnable {
    private final File rootDir;
    private File currentFile;
    String fileName;
    private int curThread;
    
    public FileFinder(String root) throws IOException {
        rootDir = new File(root);
        curThread = 0;
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }
    
    public void findFile(String file) {
        fileName = file;
        find(rootDir, file);
    }
    
    private void find (File rootDir, String fileName) {
        File [] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    // replace :
                    //find(file, fileName);
                    currentFile = file;
                    Thread t = new Thread(this);
                    t.start();
                }
            }
        }
    }

    @Override
    public void run() {
        find(currentFile, fileName);
    }
}
