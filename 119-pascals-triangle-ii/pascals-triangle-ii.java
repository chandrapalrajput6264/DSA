import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);

        long value = 1;

        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) value);

            value = value * (rowIndex - i) / (i + 1);
        }

        return row;
    }
}