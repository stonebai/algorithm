public class Solution {
    
    private String oneDigit(int num) {
        switch(num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return "";
        }
    }
    
    private String twoDigits(int num) {
        if (num <= 10) {
            return oneDigit(num);
        } else if (num > 10 && num < 20) {
            switch(num) {
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                case 13:
                    return "Thirteen";
                case 14:
                    return "Fourteen";
                case 15:
                    return "Fifteen";
                case 16:
                    return "Sixteen";
                case 17:
                    return "Seventeen";
                case 18:
                    return "Eighteen";
                case 19:
                    return "Nineteen";
            }
        } else {
            StringBuilder sb = new StringBuilder();
            if (num < 30) {
                sb.append("Twenty");
            } else if (num < 40) {
                sb.append("Thirty");
            } else if (num < 50) {
                sb.append("Forty");
            } else if (num < 60) {
                sb.append("Fifty");
            } else if (num < 70) {
                sb.append("Sixty");
            } else if (num < 80) {
                sb.append("Seventy");
            } else if (num < 90) {
                sb.append("Eighty");
            } else {
                sb.append("Ninety");
            }
            num %= 10;
            if (num != 0) {
                sb.append(" ");
                sb.append(oneDigit(num));
            }
            return sb.toString();
        }
    }
    
    private String threeDigits(int num) {
        StringBuilder sb = new StringBuilder();
        int high = num / 100;
        int low = num % 100;
        if (high != 0) {
            sb.append(oneDigit(high));
            sb.append(" ");
            sb.append("Hundred");
            if (low != 0) {
                sb.append(" ");
            }
        }
        if (low != 0) {
            sb.append(twoDigits(low));
        }
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String s1 = threeDigits(num % 1000);
        num /= 1000;
        if (num == 0) {
            return s1;
        }
        String s2 = threeDigits(num % 1000);
        num /= 1000;
        if (num == 0) {
            return s2 + " Thousand " + s1;
        }
        String s3 = threeDigits(num % 1000);
        num /= 1000;
        if (num == 0) {
            return s3 + " Million " + s2 + " Thousand " + s1;
        }
        String s4 = threeDigits(num % 1000);
        return s4 + " Billion " + s3 + " Million " + s2 + " Thousand " + s1;
    }
}