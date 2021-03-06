package br.com.ntconsultws.util;

import java.text.Normalizer;

public class TextUtil {

    private TextUtil() {
    }

    public static String adjustFilePath(final String path) {
        if (path == null) {
            return null;
        }
        return path.replaceAll("/", "\\\\");
    }

    public static String removeAccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String normalizeSpaces(final String str) {
        if (str == null) {
            return null;
        }
        return (str.trim()).replaceAll("\\s+", " ");
    }

    public static String removeNotNumbers(final String str) {
        if (str == null) {
            return null;
        }
        return (str.trim()).replaceAll("\\D", "");
    }

    public static String removeNotLetters(final String str) {
        if (str == null) {
            return null;
        }
        return (str.trim()).replaceAll("\\W", "");
    }

    public static boolean containLetter(final String str) {
        if (str == null) {
            return false;
        }
        return !(str.trim()).matches("^[0-9]*$");
    }

    public static String removeNotDigits(final String str) {
        if (str == null) {
            return null;
        }
        return (str.trim()).replaceAll("\\d+", "");
    }

    public static String stringLowerCase(final String str) {
        return str != null ? (str.trim()).toLowerCase() : str;
    }

    public static String stringUpperCase(final String str) {
        return str != null ? (str.trim()).toUpperCase() : str;
    }

    public static boolean isParmetroInformado(final String str) {
        return str != null && !(str.trim()).isEmpty() && !(str.trim()).replace("", "").contains("?") ? true : false;
    }
}