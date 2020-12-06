package other;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ajaz Badhra
 */
public class Format {
    public static String ToString(double d){
        String str=String.format("%.2f",d);
        return str;
    }
    public static String ToString(double d,int n){
        String str=String.format("%.0f",d);
        return str;
    }
}
