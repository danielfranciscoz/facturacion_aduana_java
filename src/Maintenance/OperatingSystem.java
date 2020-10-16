/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author W4LT3R
 */
public class OperatingSystem {

    public enum Systems {
        Windows,
        Mac,
        Unix,
        Solaris
    }

    private static final String NAME = System.getProperty("os.name").toLowerCase();
    private static final String ARCHITECTURA = System.getProperty("os.arch").toLowerCase();
    private static final String VERSION = System.getProperty("os.version").toLowerCase();

    public static Systems getOS() {
        if (isWindows()) {
            return Systems.Windows;
        } else if (isMac()) {
            return Systems.Mac;
        } else if (isUnix()) {
            return Systems.Unix;
        } else if (isSolaris()) {
            return Systems.Solaris;
        }
        return null;
    }

    public static boolean isWindows() {
        return NAME.contains("win");
    }

    public static boolean isMac() {
        return NAME.contains("mac");
    }

    public static boolean isUnix() {
        return NAME.contains("nix") || NAME.contains("nux") || NAME.contains("aix");
    }

    public static boolean isSolaris() {
        return NAME.contains("sunos");
    }
}
