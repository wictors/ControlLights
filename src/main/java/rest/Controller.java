package rest;

import org.springframework.web.bind.annotation.*;
import parser.ExpressionParser;
import program.model.Program;
import java.io.File;
import java.io.FileReader;

@CrossOrigin
@RestController
public class Controller {
    private static File[] listOfFiles ;
    private static String[] namesOfFiles;

    @GetMapping("/getConfigs")
    @ResponseBody
    public String[] getConfigs() {
        File configsFolder = new File("C:/Users/Admin/Desktop/Skola/Diplomovka/Configs");
        listOfFiles = configsFolder.listFiles();
        if (listOfFiles != null) {
            namesOfFiles = new String[listOfFiles.length];
            for (int i = 0; i < listOfFiles.length; i++){
                if (listOfFiles[i].isFile()) {
                    namesOfFiles[i] = listOfFiles[i].getName();
                }
            }
        }else{
            namesOfFiles = new String[1];
            System.err.println("Chybna cesta ku CONFIGSFOLDER !");
        }
        return namesOfFiles;
    }

    @PostMapping("/play")
    @ResponseBody
    public boolean playConfig(@RequestParam String name){
        for (File config : listOfFiles){
            if (config.getName().equals(name)){
                ExpressionParser ep = new ExpressionParser();
                try {
                    Program program = ep.parse(new FileReader(config));
                    program.execute();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
}
