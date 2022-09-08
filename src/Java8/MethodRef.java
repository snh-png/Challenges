package Java8;

import java.io.File;
import java.io.FileFilter;

public class MethodRef {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        //Method reference, meaning "use this method as a value".
        hiddenFiles = new File(".").listFiles(File::isHidden);

        //The function that, when called with argument file, returns (a boolean) whether the file is hidden or not.
        hiddenFiles = new File(".").listFiles(file -> file.isHidden());
    }
}
