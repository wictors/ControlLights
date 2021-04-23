package rest;

import language.ExecuteSpeechCmd;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import parser.ExpressionParser;
import parser.ParseException;
import program.model.Program;
import java.io.*;
import java.util.ArrayList;

/* SINGLETON class
* Implements interface from LightsControlSpeech --> send data to LightsControlLanguage
* Load, save, read, configurations files
* Send data or LightsControlLanguage for to set lights
* */

public class ConfigurationParser implements ExecuteSpeechCmd {

    private static ConfigurationParser configurationParser_instance = null;
    private static ArrayList<File> configurations;
    private static final String basePackage = "configurations";

    private ConfigurationParser() {
    }

    static ConfigurationParser getInstance(){
        if (configurationParser_instance == null){
            configurationParser_instance = new ConfigurationParser();
        }
        return configurationParser_instance;
    }

    boolean parseConfiguration(String nameConfiguration){
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

    void executeCommand(String command){
        ExpressionParser ep = new ExpressionParser();
        try {
            Program program = ep.parse(command);
            program.execute();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void unZipConfigurations(File fileZip) throws IOException{
        File cleanPackage = new File(basePackage);
        if (cleanPackage.isDirectory()){
            FileUtils.cleanDirectory(cleanPackage);
        }else{
            cleanPackage.mkdir();
        }
        configurations = new ArrayList<>();
        byte[] buffer = new byte[1024];
        int length;
        TarArchiveInputStream tis = new TarArchiveInputStream(new FileInputStream(fileZip));
        TarArchiveEntry tarEntry = tis.getNextTarEntry();
        while (tarEntry != null) {
            File configuration = new File(basePackage + "/" +  tarEntry.getName());
            FileOutputStream fos = new FileOutputStream(configuration);
            while ((length = tis.read(buffer)) >= 0) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            configurations.add(configuration);
            System.out.println(configuration.getName());
            tarEntry = tis.getNextTarEntry();
        }
        tis.close();
    }

    String[] getNameOfConfigs(){
        if(configurations != null) {
            String[] namesOfFiles = new String[configurations.size()];
            for (int i = 0; i < namesOfFiles.length; i++) {
                namesOfFiles[i] = configurations.get(i).getName();
            }
            return namesOfFiles;
        }
        return null;
    }

    @Override
    public void playConfig(String nameOfConfig) {
        parseConfiguration(nameOfConfig);
    }

    @Override
    public void executeCmd(String command) {
        executeCommand(command);
    }
}
