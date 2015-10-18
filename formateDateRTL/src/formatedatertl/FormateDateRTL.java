/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatedatertl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MHatem
 */
public class FormateDateRTL {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MHatem\\Desktop\\Dates.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(reverseWords(line));
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MHatem\\Desktop\\Dates_Output.txt"));
            writer.write(everything);
            writer.close();
        }
    }

    public static String reverseWords(String a) {
        String[] str = a.split("/");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            if(! str[i].equals("") && Integer.parseInt(str[i]) < 10 && str[i].charAt(0)!= '0')
                sb.append("0").append(str[i]);
            else
                sb.append(str[i]);
            if (i > 0) {
                sb.append("/");
            }
        }
        return sb.toString().trim();

    }

}
