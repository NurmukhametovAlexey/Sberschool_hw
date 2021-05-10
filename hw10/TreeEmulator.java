package ru.sbrf.lesson13.hw10;

import java.io.File;
import java.util.*;

public class TreeEmulator {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        printDir(path, new ArrayList<PseudoGraphics>());
    }

    private static void printDir(String path, List<PseudoGraphics> parentLines) {

        File file = new File(path);
        if (!file.exists()) {
            System.err.println("No such file: " + file.toString());
            return;
        }
        
        for (int i = 0; i < parentLines.size(); i++) {
            PseudoGraphics key = parentLines.get(i);
            System.out.print(pseudoGraphicsMap.get(key));
            if (key.equals(PseudoGraphics.TRIPLE_CONNECTOR))
                parentLines.set(i, PseudoGraphics.VERT_LINE);
            else if (key.equals(PseudoGraphics.DOWN_RIGHT_CONNECTOR))
                parentLines.set(i, PseudoGraphics.EMPTY_SPACE);
        }
        
        System.out.println(file.getName());

        String[] dirs = file.list();

        if (dirs == null || dirs.length == 0)
            return;

        for (int i = 0; i < dirs.length - 1; i++) {
            List<PseudoGraphics> parentLinesIntermediate = new ArrayList<>(parentLines);
            parentLinesIntermediate.add(PseudoGraphics.TRIPLE_CONNECTOR);
            printDir(path + "\\" +  dirs[i], parentLinesIntermediate);
        }

        List<PseudoGraphics> parentLinesLast = new ArrayList<>(parentLines);
        parentLinesLast.add(PseudoGraphics.DOWN_RIGHT_CONNECTOR);
        printDir(path + "\\" + dirs[dirs.length - 1], parentLinesLast);
    }

    private enum PseudoGraphics {
        EMPTY_SPACE,
        TRIPLE_CONNECTOR,
        DOWN_RIGHT_CONNECTOR,
        VERT_LINE
    }

    private static Map<PseudoGraphics, char[]> pseudoGraphicsMap = Map.of(
            PseudoGraphics.EMPTY_SPACE, new char[]{' ', ' ', ' ', ' '},
            PseudoGraphics.TRIPLE_CONNECTOR, new char[]{0x251C, 0x2500, 0x2500, 0x2500},
            PseudoGraphics.DOWN_RIGHT_CONNECTOR, new char[]{0x2514, 0x2500, 0x2500, 0x2500},
            PseudoGraphics.VERT_LINE, new char[]{0x2502, ' ', ' ', ' '});
}
