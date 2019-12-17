package com.example.dmarthambugermenu;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtil {

    public static boolean nullAndEmptyCheck(String jsonstr) {


        if (jsonstr != null)
            if (!jsonstr.equals(""))
                return true;
        return false;
    }


    public static boolean nullArrayListCheck(List l) {
        if (l != null)
            return true;

        return false;
    }


    public static boolean colorCheck(String hexColorCode) {
        if (hexColorCode == null)
            return false;
        else if (hexColorCode.equals(""))
            return false;
        Pattern pattern;
        Matcher matcher;
        final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        pattern = Pattern.compile(HEX_PATTERN);
        matcher = pattern.matcher(hexColorCode);
        return matcher.matches();

    }
}