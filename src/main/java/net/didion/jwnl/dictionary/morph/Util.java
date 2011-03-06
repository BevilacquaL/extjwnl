package net.didion.jwnl.dictionary.morph;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Util {
    public static String getLemma(String[] tokens, BitSet bits, String delimiter) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < tokens.length; i++) {
            if (i != 0 && !bits.get(i - 1)) {
                buf.append(delimiter);
            }
            buf.append(tokens[i]);
        }
        return buf.toString();
    }

    public static boolean increment(BitSet bits, int size) {
        int i = size - 1;
        while (i >= 0 && bits.get(i)) {
            bits.set(i--, false);
        }
        if (i < 0) {
            return false;
        }
        bits.set(i, true);
        return true;
    }

    public static String[] split(String str) {
        char[] chars = str.toCharArray();
        List<String> tokens = new ArrayList<String>();
        StringBuffer buf = new StringBuffer();
        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') || aChar == '\'') {
                buf.append(aChar);
            } else {
                if (buf.length() > 0) {
                    tokens.add(buf.toString());
                    buf = new StringBuffer();
                }
            }
        }
        if (buf.length() > 0) {
            tokens.add(buf.toString());
        }
        return tokens.toArray(new String[tokens.size()]);
    }

    private Util() {
    }
}