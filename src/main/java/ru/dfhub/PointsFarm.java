package ru.dfhub;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class PointsFarm {

    private static Color claimButtonColor;
    private static int[] claimButtonPosition = new int[2];
    private static int i = 0;

    public static void run() throws InterruptedException {
        init();
        System.out.println("Farm started!");

        while (true) {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));

            if (!check()) continue;

            Main.getRobot().mouseMove(claimButtonPosition[0], claimButtonPosition[1]);
            Thread.sleep(100);
            Main.getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK); Thread.sleep(1);
            Main.getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK); Thread.sleep(1);
            Main.getRobot().mouseMove(0, 0);

            i++;
            System.out.printf("Drops received: %s%n", i);
            Thread.sleep(500);
        }
    }

    private static void init() {
        claimButtonColor = new Color(
                Config.getConfig().getJSONObject("claim-button-color").getInt("R"),
                Config.getConfig().getJSONObject("claim-button-color").getInt("G"),
                Config.getConfig().getJSONObject("claim-button-color").getInt("B")
        );
        claimButtonPosition[0] = Config.getConfig().getJSONObject("claim-button-position").getInt("x");
        claimButtonPosition[1] = Config.getConfig().getJSONObject("claim-button-position").getInt("y");
    }

    public static boolean check() {
        return Main.getRobot().getPixelColor(claimButtonPosition[0], claimButtonPosition[1]).equals(claimButtonColor);
    }
}
