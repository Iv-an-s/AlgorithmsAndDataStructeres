package lectures.lecture5Recursion;

import java.io.File;

public class ShowFiles {

    public static void main(String[] args) {
        File root = new File("c:\\Users\\Ivan\\Desktop");
        viewDir("", root);
    }

    private static void viewDir(String prefix, File root) {
        if (root.isFile()){
            System.out.println(prefix + "File: " + root.getName());
        }else {
            System.out.println(prefix + "Dir: " + root.getName());
            File []files = root.listFiles();
            for (File file : files){
                viewDir(prefix + "  ", file);
            }
        }
    }
}
