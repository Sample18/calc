import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Совершите операцию (+,-,*,/) с числами от 1 до 10, либо Римскими цифрами. Перед и после оператора должен стоять пробел (например 1 + 3).");
        Scanner in = new Scanner(System.in);
        String result =  calc(in.nextLine());
        in.close();
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String[] data = input.trim().split(" ");
        String result;

        if (data.length != 3){
            throw new Exception();
        } else {
            String a = data[0];
            String sign = data[1];
            String b = data[2];
            boolean isRomChar1 = Utils.searchRomChar(data[0]);
            boolean isRomChar2 = Utils.searchRomChar(data[2]);
            if(isRomChar1 && isRomChar2) {
                result = performAnOperation(sign, Utils.toArabicNumber(a),Utils.toArabicNumber(b));
                if (Integer.parseInt(result)>0) {
                    return Utils.convertToRoman(Integer.parseInt(result));
                } else {
                    throw new Exception();
                }
            } else if (Utils.isNumber(a) && Utils.isNumber(b) && Utils.checkedNumber(a) && Utils.checkedNumber(b)) {
                result = performAnOperation(sign, a, b);
            } else {
                throw new Exception();
            }
        }
        return result;
    }

    static String performAnOperation(String sign, String a, String b) throws Exception {
        String result;
        switch (sign){
            case "+":
                result = increment(a,b);
                break;
            case "-":
                result = decrement(a, b);
                break;
            case "*":
                result = multiply(a, b);
                break;
            case "/":
                result = division(a, b);
                break;
            default:
                throw new Exception();
        }
        return result;
    }

    static String increment(String a, String b) {
        int res = Integer.parseInt(a) + Integer.parseInt(b);
        return Integer.toString(res);
    }

    static String decrement(String a, String b) {
        int res = Integer.parseInt(a) - Integer.parseInt(b);
        return Integer.toString(res);
    }

    static String multiply(String a, String b) {
        int res = Integer.parseInt(a) * Integer.parseInt(b);
        return Integer.toString(res);
    }

    static String division(String a, String b) {
        int res = Integer.parseInt(a) / Integer.parseInt(b);
        return Integer.toString(res);
    }
}
