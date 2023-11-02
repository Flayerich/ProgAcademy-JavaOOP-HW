package hw5;

import java.io.File;
import java.io.FilenameFilter;

public class PdfFileFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".pdf");
    }
}
