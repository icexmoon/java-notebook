package ch17.encode5;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charSets.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String aliaseName : entry.getValue().aliases()) {
                System.out.print(aliaseName + ", ");
            }
            System.out.println();
        }
    }
}
// x-MS932_0213:
// MS932:2004, windows-932:2004, MS932_0213, MS932-0213, windows-932-0213,
// x-MS950-HKSCS:
// MS950_HKSCS,
// x-MS950-HKSCS-XP:
// MS950_HKSCS_XP,
// x-mswin-936:
// ms936, ms_936,