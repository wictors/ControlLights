package rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@CrossOrigin
@RestController
public class Controller {

    private static final String API_TOKEN = "PasswordApi0000";

    @GetMapping("/getConfigs")
    @ResponseBody
    public String[] getConfigs() {
        ConfigurationParser parser = ConfigurationParser.getInstance();
        return parser.getNameOfConfigs();
    }

    @PostMapping("/play")
    @ResponseBody
    public boolean playConfig(@RequestParam String name){
        ConfigurationParser parser = ConfigurationParser.getInstance();
        return parser.parseConfiguration(name);
    }

    @GetMapping("/play2")
    @ResponseBody
    public boolean playConfig2(@RequestParam String name){
        ConfigurationParser parser = ConfigurationParser.getInstance();
        return parser.parseConfiguration(name);
    }

    @GetMapping("/execute")
    public void executeCmd(@RequestParam String name){
        ConfigurationParser parser = ConfigurationParser.getInstance();
        parser.executeCommand(name);
    }

    @PostMapping("/setConfigs")
    @ResponseBody
    public ResponseEntity setConfigs(@RequestParam("file") MultipartFile configurations,
                                     @RequestParam("token") String token) {
        if (token.equals(API_TOKEN)) {
            String fileName = StringUtils.cleanPath(configurations.getOriginalFilename());
            Path path = Paths.get(fileName);
            try {
                Files.copy(configurations.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                File configs = new File(String.valueOf(path));
                ConfigurationParser parser = ConfigurationParser.getInstance();
                parser.unZipConfigurations(configs);
                return new ResponseEntity(HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println(token);
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
