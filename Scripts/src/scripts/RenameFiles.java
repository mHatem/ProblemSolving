/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Mhatem
 */
public class RenameFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File folder = new File("D:\\Gallary\\Filtered\\");
        File[] listOfFiles = folder.listFiles();

        Arrays.sort(listOfFiles, new Comparator<File>() {
            public int compare(File f1, File f2) {
                return Long.compare(f1.lastModified(), f2.lastModified());
            }
        });
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                File f = new File("D:\\Gallary\\Filtered\\" + listOfFiles[i].getName());

                f.renameTo(new File("D:\\Gallary\\Filtered\\" + i + ".jpg"));
            }
        }

    }

}
