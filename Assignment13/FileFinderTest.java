package assignment13;

import java.io.IOException;

/**
 *
 * @author pieterkoopman
 */
public class FileFinderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OO15FileFinderTest fft = new OO15FileFinderTest();
         FileFinderTest();
    }

    public FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "/Users/Laurens/Desktop";
            FileFinder ff = new FileFinder(root);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }

    public static void FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "/Users/Laurens/Documents";
            FileFinder ff = new FileFinder(root);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }
    /*
    public OO15FileFinderTest() {
        try {
            String goal = "FileFinderSeq.java";
            FileFinderSeq ff = new FileFinderSeq("/Users/pieterkoopman/Documents/onderwijs/OO/OO 2015/OO 2015 projects");
            File file = ff.findFile(goal);
            if (file != null) {
                System.out.println("found: " + file.getAbsolutePath());
            } else {
                System.out.println(goal + " not found.");
            }
        } catch (IOException e) {
            System.err.println( e );
        }
    }
*/
}
