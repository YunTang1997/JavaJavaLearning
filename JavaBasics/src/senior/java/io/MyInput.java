package senior.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MyInput.java: Contain the methods for reading int, double, float, boolean, short, byte and
 * string values from the keyboard
 * @author YunTang
 * @create 2020-07-29 15:16
 */

public class MyInput {

    public static void main(String[] args) {

//        System.out.println(MyInput.readString());
//       System.out.println(MyInput.readByte());
//       System.out.println(MyInput.readFloat());

    }

    public static String readString(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        try {
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static byte readByte(){
        return Byte.parseByte(readString());
    }

    public static short readShort(){
        return Short.parseShort(readString());
    }

    public static long readLong(){
        return Long.parseLong(readString());
    }

    public static float readFloat(){
        return Float.parseFloat(readString());
    }
}
