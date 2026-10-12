class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                int len2 = j - i;

                if (len2 > n - j) {
                    break;
                }

                if (len2 > 1 && num.charAt(i) == '0') {
                    break;
                }

                String first = num.substring(0, i);
                String second = num.substring(i, j);

                if (check(num, j, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String num, int index,
                          String first, String second) {
        int n = num.length();
        int count = 2;

        while (index < n) {
            String sum = add(first, second);

            if (!num.startsWith(sum, index)) {
                return false;
            }

            index += sum.length();
            first = second;
            second = sum;
            count++;
        }

        return count >= 3;
    }

    private String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}