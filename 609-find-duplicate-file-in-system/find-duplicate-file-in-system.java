import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            int n = path.length();
            int space = path.indexOf(' ');

            String directory = path.substring(0, space);
            int start = space + 1;

            while (start < n) {
                int open = path.indexOf('(', start);
                int close = path.indexOf(')', open);

                String content = path.substring(open + 1, close);
                String filePath = directory + "/" + path.substring(start, open);

                List<String> files = map.get(content);

                if (files == null) {
                    files = new ArrayList<>();
                    map.put(content, files);
                }

                files.add(filePath);

                start = close + 2;
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> files : map.values()) {
            if (files.size() > 1) {
                result.add(files);
            }
        }

        return result;
    }
}