/*
 * Copyright (C) 2016 The CyanogenMod Project
 *      http://www.apache.org/licenses/LICENSE-2.0
 */

package org.cyanogenmod.hardware;

import org.cyanogenmod.hardware.util.FileUtils;
import java.io.File;

/*
 * Disable capacitive keys - Legacy for SlimROM
 */

public class KeyDisabler {

    private static String CONTROL_PATH = "/proc/touchscreen/nav_button_enable";

    public static boolean isSupported() {
        return new File(CONTROL_PATH).exists();
    }

    public static boolean isActive() {
        return (FileUtils.readOneLine(CONTROL_PATH).equals("0"));
    }

    public static boolean setActive(boolean state) {
        return FileUtils.writeLine(CONTROL_PATH, (state ? "0" : "1"));
    }

}
