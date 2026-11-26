class Solution {
    public String solveEquation(String equation) {
        int xCoeff = 0;
        int constant = 0;
        int side = 1;
        int i = 0;
        int n = equation.length();

        while (i < n) {
            if (equation.charAt(i) == '=') {
                side = -1;
                i++;
                continue;
            }

            int sign = 1;
            if (equation.charAt(i) == '+') {
                i++;
            } else if (equation.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int number = 0;
            boolean hasNumber = false;

            while (i < n && equation.charAt(i) >= '0'
                    && equation.charAt(i) <= '9') {
                number = number * 10 + equation.charAt(i) - '0';
                i++;
                hasNumber = true;
            }

            if (i < n && equation.charAt(i) == 'x') {
                xCoeff += side * sign * (hasNumber ? number : 1);
                i++;
            } else {
                constant += side * sign * number;
            }
        }

        if (xCoeff == 0) {
            return constant == 0 ? "Infinite solutions" : "No solution";
        }

        return "x=" + (-constant / xCoeff);
    }
}