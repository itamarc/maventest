package io.github.itamarc.mavtest;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import org.gjt.itemplate.ITemplate;

public class TemplateProcessor {
    static String templatesPath = "";
    static String destinationPath = "";

    public TemplateProcessor(String tmplPath, String destPath) {
        templatesPath = tmplPath;
        destinationPath = destPath;
    }

    public String run() {
        ITemplate tmpl = null;
        try {
            // tmpl = new ITemplate(getResourceFile("README.tmpl.md").getAbsolutePath(), "path");
            tmpl = new ITemplate(templatesPath+"/README.tmpl.md", "path");
            
        } catch (Exception e) {
            Logger log = Logger.getLogger(this.getClass().getName());
            log.warning(e.getClass().getCanonicalName()+": "+e.getMessage() + " - " + e.getStackTrace().toString());
            return null;
        }
        HashMap<String, String> values = getValuesMap();
        String filledTmpl = tmpl.fill(values);
        writeFile(filledTmpl, destinationPath+"/README.md");
        return filledTmpl;
    }

    private HashMap<String, String> getValuesMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("lastupdate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return map;
    }

/**
	 * Write a string to a file.
	 *
	 * @param text The string to write to the file.
	 * @param path The path of the file to be writen.
	 */
	private void writeFile(String text, String path) {
		FileWriter out;
        try {
            out = new FileWriter(path);
            out.write(text);
            out.close();
        } catch (IOException e) {
            Logger log = Logger.getLogger(this.getClass().getName());
            log.warning(e.getClass().getCanonicalName()+": "+e.getMessage() + " - " + e.getStackTrace().toString());
        }
	}
}
