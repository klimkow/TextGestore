/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klimkov.textgestore.report;

/**
 *
 * @author Nigga
 */
public class GenerateReport {
    private static StringBuilder sb = new StringBuilder();
    public static void append(String s){
        sb.append(s);
        sb.append("\n");
    }
    public static void generate(){
        System.out.print(sb);
    }
}
