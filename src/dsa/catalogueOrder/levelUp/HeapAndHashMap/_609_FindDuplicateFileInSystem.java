package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _609_FindDuplicateFileInSystem {
    public static void main(String[] args) {
        String[] paths = {"root/a a.txt(efsfgh) aa.txt(efsfgh) aaa.txt(efsfgh)", "root/c/a 3.txt(efsfgh)", "root/c/d 4.txt(efsfgh)"};
        System.out.println(findDuplicate(paths));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String dir = files[0];
            for (int i = 1; i < files.length; i++) {
                String[] fileInfo = getFileName(files[i]);
                List<String> dirs = map.getOrDefault(fileInfo[1], new ArrayList<>());
                String dirName = new StringBuilder(dir).append("/").append(fileInfo[0]).toString();
                dirs.add(dirName);
                map.put(fileInfo[1], dirs);
            }
        }

        for (List<String> val : map.values()) {
            if (val.size() > 1)
                ans.add(val);
        }
        return ans;
    }


    private static String[] getFileName(String completeFileName) {
        StringBuilder fileName = new StringBuilder("");
        int start = 0;
        int end = completeFileName.length() - 1;
        for (int i = 0; i < completeFileName.length(); i++) {
            if (completeFileName.charAt(i) == '(') {
                start = i;
                break;
            } else {
                fileName.append(completeFileName.charAt(i));
            }
        }
        return new String[]{fileName.toString(), completeFileName.substring(start + 1, end)};
    }
}
