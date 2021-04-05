package rest;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import parser.ExpressionParser;
import parser.ParseException;
import program.model.Program;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* SINGLETON class*/

public class ConfigurationParser {

    private static ConfigurationParser configurationParser_instance = null;
    private static ArrayList<File> configurations;
    private static final String basePackage = "configurations";

    private ConfigurationParser() {
    }

    public static ConfigurationParser getInstance(){
        if (configurationParser_instance == null){
            configurationParser_instance = new ConfigurationParser();
        }
        return configurationParser_instance;
    }

    public boolean parseConfiguration(String nameConfiguration){
        if(configurations != null) {
            for (File configuration : configurations) {
                if (configuration.getName().equals(nameConfiguration)) {
                    ExpressionParser ep = new ExpressionParser();
                    try {
                        FileReader fileReader = new FileReader(configuration);
                        Program program = ep.parse(fileReader);
                        program.execute();
                        fileReader.close();
                        return true;
                    } catch (ParseException | IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean executeCommand(String command){
        ExpressionParser ep = new ExpressionParser();
        try {
            Program program = ep.parse(command);
            program.execute();
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unZipConfigurations (File fileZip) throws IOException{
        File cleanPackage = new File(basePackage);
        FileUtils.cleanDirectory(cleanPackage);
        configurations = new ArrayList<>();
        byte[] buffer = new byte[1024];
        int length;
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File configuration = new File(basePackage + "/" +  zipEntry.getName());
            FileOutputStream fos = new FileOutputStream(configuration);
            while ((length = zis.read(buffer)) >= 0) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            configurations.add(configuration);
            System.out.println(configuration.getName());
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    public String[] getNameOfConfigs(){
        if(configurations != null) {
            String[] namesOfFiles = new String[configurations.size()];
            for (int i = 0; i < namesOfFiles.length; i++) {
                namesOfFiles[i] = configurations.get(i).getName();
            }
            return namesOfFiles;
        }
        return null;
    }
}
