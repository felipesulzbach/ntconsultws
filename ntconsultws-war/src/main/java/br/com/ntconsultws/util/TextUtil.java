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
        return (str.trim()).replaceAll("[^a-zA-Z]", "");
    }

    public static String stringLowerCase(final String str) {
        return str != null ? (str.trim()).toLowerCase() : str;
    }

    public static String stringUpperCase(final String str) {
        return str != null ? (str.trim()).toUpperCase() : str;
    }
}