public class Utils {

    static boolean checkedNumber(String value){
        return Integer.parseInt(value)>0 && Integer.parseInt(value)<11;
    }

    static String convertToRoman(int num) throws Exception {
        if (num < 1 || num > 3999) {
            throw new Exception();
        }

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] arabicValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder romanNumber = new StringBuilder();

        int i = arabicValues.length - 1;
        while (num > 0) {
            if (num >= arabicValues[i]) {
                romanNumber.append(romanSymbols[i]);
                num -= arabicValues[i];
            } else {
                i--;
            }
        }

        return romanNumber.toString();
    }
    static boolean searchRomChar(String value) {
        String[] romNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        boolean found = false;

        for (String str : romNumbers) {
            if (str.equals(value.toUpperCase())) {
                found = true;
                break;
            }
        }
        return found;
    }
    static String toArabicNumber(String romNumb){
        String result = null;
        switch (romNumb.toUpperCase()){
            case "I":
                result = "1";
                break;
            case "II":
                result = "2";
                break;
            case "III":
                result = "3";
                break;
            case "IV":
                result = "4";
                break;
            case "V":
                result = "5";
                break;
            case "VI":
                result = "6";
                break;
            case "VII":
                result = "7";
                break;
            case "VIII":
                result = "8";
                break;
            case "IX":
                result = "9";
                break;
            case "X":
                result = "10";
                break;
        }
        return result;
    }

    static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }
}
