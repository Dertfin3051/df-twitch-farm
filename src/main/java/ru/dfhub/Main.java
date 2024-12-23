package ru.dfhub;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String version = "1.0";
    public static Scanner input = new Scanner(System.in);
    private static Robot robot;

    public static void main(String[] args) {
        try {
            init();
        } catch (AWTException e) {
            System.out.println("Can't init GUI-bot! (%s)".formatted(e.getMessage()));
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Welcome to DF Twitch Farm!");
        System.out.println("Please check if you have configured the config.json file before starting the farm.");
        System.out.println("Full installation guide here: https://github.com/Dertfin3051/df-twitch-farm/blob/master/README.md\n");
        System.out.println("Press enter to start farm...");
        input.nextLine();
        try {
            PointsFarm.run();
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }

    /**
     * Check and set-up config, GUI-bot, print ascii art
     * @throws IOException Any critical init exception
     */
    public static void init() throws IOException, AWTException {
        if (!new File(System.getProperty("user.home")).exists()) throw new IOException("[System Error] Can't find home directory!");
        Config.generate();
        Config.init();
        robot = new Robot();
        printAsciiArt();
    }

    private static void printAsciiArt() {
        System.out.printf("""
        ================================================
        |    ██████╗ ███████╗   ████████╗██╗    ██╗    |
        |    ██╔══██╗██╔════╝██╗╚══██╔══╝██║    ██║    |
        |    ██║  ██║█████╗  ╚═╝   ██║   ██║ █╗ ██║    |
        |    ██║  ██║██╔══╝  ██╗   ██║   ██║███╗██║    |
        |    ██████╔╝██║     ╚═╝   ██║   ╚███╔███╔╝    |
        |    ╚═════╝ ╚═╝           ╚═╝    ╚══╝╚══╝     |
        == DF Twitch Farm v%-3s =========================%n%n
        """, version);
    }

    public static Robot getRobot() {
        return robot;
    }
}