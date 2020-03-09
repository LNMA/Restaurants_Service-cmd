package com.louay.projects.io;

import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

public interface IOOut {

    public static void write(Object o){
        File file = new File("sales.dat");
        if (file.exists()){
            iOOutExist(o);
        }else
            iOOutNew(o);
    }
    private static void iOOutExist(Object o){
        try(AppendingObjectOutputStream out = new AppendingObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sales.dat",true)))){
            out.writeObject(o);
            out.writeStreamHeader();
        }
        catch (IOException e){
            System.out.print("\n>> "+e.getMessage()+"\n");
        }
    }
    private static void iOOutNew(Object o){
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sales.dat",false)))){
            out.writeObject(o);
        }
        catch (IOException e){
            System.out.print("\n>> "+e.getMessage()+" \n");
        }
    }
    public static void checkToSaveAll(){
        File file = new File("sales.dat");
        if (file.exists())
            file.delete();
    }


    private static void reportNew(String s,double n){
        try(PrintWriter out = new PrintWriter(new FileOutputStream(new File("report.txt"),false))){
            out.print(s);
            out.print(n);
            out.close();
        }
        catch (IOException e){
            System.out.print("\n>> "+e.getMessage()+" \n");
        }

    }

    private static void reportAppend(String s,double n){
        try(PrintWriter out = new PrintWriter(new FileOutputStream(new File("report.txt"),true))){
            out.append(s);
            out.append(String.valueOf(n));
            out.close();
        }
        catch (IOException e){
            System.out.print("\n>> "+e.getMessage()+" \n");
        }
    }

    public static void writeReport(String s,double n){
        File file = new File("report.txt");
        if (file.exists())
            reportAppend(s,n);
        else
            reportNew(s,n);
    }
    static void deleteReport(){
        File file = new File("report.txt");
        file.delete();
    }
}









