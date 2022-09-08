package JavaCore.FileSamples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class FilesIO {
    public static void main(String[] args) {
        String str = "xyz";
        byte[] bytes = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < 2; ++i) {
            int res;
            while ((res = bais.read()) != -1) {
                if(i == 0) {
                    System.out.println(Character.toUpperCase((char) res));
                    baos.write(res);
                }
            }
            System.out.println(baos);
        }
    }
}