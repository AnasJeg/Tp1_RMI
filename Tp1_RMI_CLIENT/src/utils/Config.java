/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author anace
 */
public class Config {
    public static String url;
       private static Config config;
    
    static {
        FileInputStream f = null;
        try {
            f = new FileInputStream("config.properties");
            Properties p = new Properties();
            p.load(f);
            config.url = p.getProperty("url");
   
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
            }
        }
    }

    public static Config getConfig() {
        return config;
    }
}
