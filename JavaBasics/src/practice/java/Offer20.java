package practice.java;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * @author YunTang
 * @create 2020-08-16 17:29
 */
public class Offer20 {

    public static void main(String[] args) {

        Offer20 offer20 = new Offer20();
        System.out.println(offer20.isNumber("-1E-16"));
        System.out.println(offer20.isNumber("12e+5.4"));
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false; // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        boolean isNum = false, isDot = false, iseOrE = false; // 标记是否遇到数字、小数点、'e'或'E'
        // 转为字符数组，遍历判断每个字符
        char[] sChar = s.trim().toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] >= '0' && sChar[i] <= '9') isNum = true; // 判断当前字符是否为0~9的数字
            else if (sChar[i] == '.') { // 遇到小数点
                if (isDot || iseOrE) return false; // 小数点之前可以没有整数，但是不能重复出现小数点、或出现'e'、'E'
                isDot = true; // 标记已经遇到小数点
            }
            else if (sChar[i] == 'e' || sChar[i] == 'E') { // 遇到'e'或'E'
                if (!isNum || iseOrE) return false; // 'e'或'E'前面必须有整数，且前面不能重复出现'e'或'E'
                iseOrE = true; // 标记已经遇到'e'或'E'
                isNum = false; // 重置isNum，因为'e'或'E'之后也必须接上整数，防止出现123e或者123e+的非法情况
            }
            else if (sChar[i] == '-' || sChar[i] == '+') {
                if (i != 0 && sChar[i - 1] != 'E' && sChar[i - 1] == 'e') return false; // 正负号只可能出现在第一个位置，或者出现在'e'或'E'的后面一个位置
            }
            else return false; // 其它情况均为不合法字符
        }
        return isNum;
    }
}



