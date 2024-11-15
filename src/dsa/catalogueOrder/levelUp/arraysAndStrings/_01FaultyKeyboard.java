package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _01FaultyKeyboard {

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false; // impossible to make name_str from typed_str

        int i = 0; // index for name
        int j = 0; // index for typed
        while (i < name.length() && j < typed.length()) {

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < typed.length()) {
            if (i > 0 && name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }

        if (i < name.length()) return false;

        return true;
    }
}
