
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] a = parse(num1);
        int[] b = parse(num2);

        int real = a[0] * b[0] - a[1] * b[1];
        int imaginary = a[0] * b[1] + a[1] * b[0];

        return real + "+" + imaginary + "i";
    }

    private int[] parse(String s) {
        int i = 0, sign = 1, real = 0, imaginary = 0;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (s.charAt(i) != '+') {
            real = real * 10 + s.charAt(i++) - '0';
        }
        real *= sign;

        i++;
        sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (s.charAt(i) != 'i') {
            imaginary = imaginary * 10 + s.charAt(i++) - '0';
        }

        imaginary *= sign;

        return new int[]{real, imaginary};
    }
}
