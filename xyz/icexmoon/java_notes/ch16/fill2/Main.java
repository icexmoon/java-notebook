package ch16.fill2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Fmt;

class AddrStr {
    private String str;

    public AddrStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        String addr = super.toString();
        return Fmt.sprintf("AddrStr(%s:%s)", addr, str);
    }
}

public class Main {
    public static void main(String[] args) {
        List<AddrStr> strings = new ArrayList<>();
        String[] words = "abc".split("");
        for (String w : words) {
            strings.add(new AddrStr(w));
        }
        System.out.println(strings);
        Collections.fill(strings, new AddrStr("z"));
        System.out.println(strings);
    }
}
// [AddrStr(ch16.fill2.AddrStr@24d46ca6:a),
// AddrStr(ch16.fill2.AddrStr@6d311334:b),
// AddrStr(ch16.fill2.AddrStr@682a0b20:c)]
// [AddrStr(ch16.fill2.AddrStr@3d075dc0:z),
// AddrStr(ch16.fill2.AddrStr@3d075dc0:z),
// AddrStr(ch16.fill2.AddrStr@3d075dc0:z)]