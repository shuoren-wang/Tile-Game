package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by shuorenwang on 2016-07-16.
 */
public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line = null;
            while((line=br.readLine())!=null){
                builder.append(line+"\n");
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int parseInt(String number){
        try{
        return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }


}
