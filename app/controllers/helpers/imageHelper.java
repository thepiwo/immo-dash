package controllers.helpers;

import java.io.*;

/**
 * Created by Philipp on 13.06.2015.
 */
public class imageHelper {

    public static void moveFile(File afile, File bfile) {

        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();

            //delete the original file
            afile.delete();

            System.out.println("File is copied successful!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
