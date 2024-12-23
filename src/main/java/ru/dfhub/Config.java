package ru.dfhub;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {

    private static JSONObject config;

    /**
     * Creates a new config if it does not exist
     */
    public static void generate() throws IOException{
        try {
            File configFile = new File("config.json");
            if (!configFile.exists()) {
                configFile.createNewFile();

                PrintWriter pw = new PrintWriter(configFile);
                pw.write(getDefaultConfig());
                pw.flush();
                pw.close();
                System.out.println("Config file generated successfully. Please, configure it");
            }
        } catch (IOException e) {
            throw new IOException("Can't create configuration file!");
        }
    }

    public static JSONObject getConfig() {
        return config;
    }

    public static void saveConfig(JSONObject newConfig) {
        config = newConfig;
        try (
            PrintWriter pw = new PrintWriter("config.json")
        ) {
            pw.write(newConfig.toString());
            pw.flush();
        } catch (IOException e) {
            System.out.println("Can't save config file!");
        }
    }

    public static void init() throws IOException {
        try {
            config = new JSONObject(Files.readString(Path.of("config.json")));
        } catch (IOException e) {
            throw new IOException("Can't read config file!");
        }
    }

    private static String getDefaultConfig() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.json")));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return new JSONObject(sb.toString()).toString(4);
    }

}
