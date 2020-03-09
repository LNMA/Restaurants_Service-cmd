package com.louay.projects.view;



import com.louay.projects.entry.DrinksOrder;
import com.louay.projects.entry.SandwichesOrder;
import com.louay.projects.io.IOIn;
import com.louay.projects.io.IOOut;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface extends IOIn implements Serializable {
    Scanner input = new Scanner(System.in);

    public int inputOrderID(){
        int id = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\t   please input Order ID.  \t\t\t  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            id = input.nextInt();
            if (id < 0)
                throw new IllegalArgumentException("\n>> the id can not be negative\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            id = inputOrderID();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input integer numbers only\n");
            input.nextLine();
            id = inputOrderID();
        }
        return id;
    }

    private void menu(){
        System.out.print("\n|-|-|-|-|-|-|-|-|-|-|-|-|-|-|  \n| **we glad to serve you**  |"+"\n|   Please see the menu...  | \n|-|-|-|-|-|-|-|-|-|-|-|-|-|-| \n^|^|^|^|^|^|^|^|^|^|^|^|^|^|^" +"\n_____________________________ \n|\t\t\t\t\t\t    |  \n|\t\t  \\/ Menu \\/  \t\t| \n|___________________________| \n|\t\t\t\t\t\t    |"+" \n|Soft drink.......... 0.5JD | \n|___________________________|"+" \n|\t\t\t\t\t\t    | \n|sandwich............ 1.25JD| \n|___________________________| ");
    }

    private int inputNumberOfDrinks(){
        int num =0;
        try{
            System.out.print("\n******************************************************* \n| Please input the quantity of Soft drink.\t\t\t  | \n|\t\t\t\t\t\t\t\t\t\t\t\t\t  | \n|   <number> of soft drink, please.\t\t\t\t\t  |\n|\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n******************************************************* \nYou:\\>");
            num = input.nextInt();
            if (num<=0)
                throw new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            num = inputNumberOfDrinks();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> You can just enter integer numbers only.\n");
            input.nextLine();
            num = inputNumberOfDrinks();
        }
        return num;
    }

    private int inputNumberOfSandwiches(){
        int num =0;
        try{
            System.out.print("\n******************************************************* \n| Please input the quantity of Sandwiches.\t\t\t  | \n|\t\t\t\t\t\t\t\t\t\t\t\t\t  | \n|   <number> of Sandwiches, please.\t\t\t\t\t  |\n|\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n******************************************************* \nYou:\\>");
            num = input.nextInt();
            if (num<=0)
                throw  new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            num = inputNumberOfSandwiches();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> You can just enter integer numbers only.\n");
            input.nextLine();
            num = inputNumberOfSandwiches();
        }
        return num;
    }

    private String inputYesNoChoice(){
        String yesNo = null;
        try {
            System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n| Would you like to perform a new operation.  | \n|                                             | \n| <Y>es, I would.        <N>o, thanks.        |\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \nYou:\\>");
            yesNo = input.next();
            if (input.hasNextLine())
                yesNo += input.nextLine();
            if (!(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("n")))
                throw new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            yesNo = inputYesNoChoice();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> wrong input.\n");
            input.nextLine();
            yesNo = inputYesNoChoice();
        }
        return yesNo;
    }



    private String inputOperation(){
        String choice = "null";
        try{
            System.out.print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n| What type of operation you need?\t\t\t\t\t\t  | \n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | \n|<N>ew order,please.       <E>dit order, maybe.\t\t\t  | \n|<M>ore, options.\t\t\t\t\t\t\t\t\t\t  | \n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \nYou:\\>");
            choice = input.next();
            if(input.hasNextLine())
                choice += input.nextLine();
            if (!(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("E") || choice.equalsIgnoreCase("M")))
                throw new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            choice = inputOperation();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> wrong input\n");
            input.nextLine();
            choice = inputOperation();
        }
        return choice;
    }

    private String inputMyChoice(){
        String choice = "null";
        try{
            System.out.print("\n************************************************** \n| How can we help you?\t\t\t\t\t\t\t | \n|\t\t\t\t\t\t\t\t\t\t\t     | \n|   <S>andwiches, please.\t<D>rink, please.\t |\n|   <M>ain screen, please.\t\t\t\t\t     |\n************************************************** \nYou:\\>");
            choice = input.next();
            if(input.hasNextLine())
                choice += input.nextLine();
            if (!(choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d") || choice.equalsIgnoreCase("m")))
                throw new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            choice = inputMyChoice();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> wrong input.\n");
            input.nextLine();
            choice = inputMyChoice();
        }
        return choice;
    }

    private void ShowMeMoreOption(){
        System.out.print("\n[][][][][][][][][][][][][][][][][][][][][]\nSelect the operation number: \n[][][][][][][][][][][][][][][][][][][][][] \n[1]. get all id. \n[2]. get all number of Sandwiches order. \n[3]. get all number of drinks order. \n[4]. get all price of Sandwiches order. "
                + "\n[5]. get all price of drinks order. \n[6]. get all data. \n[7]. get totals bills. \n[8]. Go to main screen. \n[9]. Creat report.txt file. \n[10]. exit.\n[][][][][][][][][][][][][][][][][][][][][] \nYou:\\>");
    }

    private int inputMoreOption (){
        int choice = 0;
        try{
            choice = input.nextInt();
            if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9 || choice == 10))
                throw new IllegalArgumentException("\n################################################\n  Sorry you are input invalid value..try again   \n################################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            ShowMeMoreOption();
            choice = inputMoreOption();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> You can just enter integer numbers only.\n");
            input.nextLine();
            ShowMeMoreOption();
            choice = inputMoreOption();
        }
        return choice;
    }



    public void triggerMethod(){
        iOIn();
        setLastID();
        String yesNo = null;
        String order = null;
        String mainOperation ;
        int newIdOrder ;
        do{
            menu();
            do{
                setNewSize();
                newIdOrder = freeI();
                mainOperation = inputOperation();
                if (mainOperation.equalsIgnoreCase("n")) {
                    order = inputMyChoice();
                    if (order.equalsIgnoreCase("s")) {
                        sequence[newIdOrder] = new SandwichesOrder(inputNumberOfSandwiches());
                        IOOut.write(sequence[newIdOrder]);
                    }
                    if (order.equalsIgnoreCase("d")) {
                        sequence[newIdOrder] = new DrinksOrder(inputNumberOfDrinks());
                        IOOut.write(sequence[newIdOrder]);
                    }
                    if (order.equalsIgnoreCase("m")){
                        continue;
                    }
                }

                if (mainOperation.equalsIgnoreCase("e")) {
                    int id = idSearching(inputOrderID());
                    if (sequence[id] instanceof SandwichesOrder) {
                        ((SandwichesOrder) sequence[id]).setNumbersOfSandwiches(inputNumberOfSandwiches());
                    }
                    if (sequence[id] instanceof DrinksOrder){
                        ((DrinksOrder) sequence[id]).setNumberOfDrinks(inputNumberOfDrinks());
                    }
                }

                if (mainOperation.equalsIgnoreCase("m"))
                    continue;

            }while (!mainOperation.equalsIgnoreCase("m"));

            ShowMeMoreOption();
            int choice = inputMoreOption();
            if (choice == 1 ) {
                for (int i = 0; i < sequence.length; i++)
                    if (sequence[i] != null )
                        System.out.println(sequence[i].getOrderID());
            }
            if (choice == 2) {
                for (int i = 0; i < sequence.length; i++)
                    if (sequence[i] != null )
                        if (sequence[i] instanceof SandwichesOrder)
                            System.out.println(((SandwichesOrder)sequence[i]).getNumbersOfSandwiches());
            }
            if (choice == 3) {
                for (int i = 0; i < sequence.length; i++)
                    if (sequence[i] != null )
                        if (sequence[i] instanceof  DrinksOrder)
                            System.out.println(((DrinksOrder)sequence[i]).getNumberOfDrinks());
            }
            if (choice == 4) {
                for (int i = 0; i < sequence.length; i++)
                    if (sequence[i] != null )
                        if (sequence[i] instanceof SandwichesOrder)
                            System.out.println(((SandwichesOrder)sequence[i]).getPricesOfSandwiches());
            }
            if (choice == 5 ) {
                for (int i = 0; i < sequence.length; i++)
                    if (sequence[i] != null )
                        if (sequence[i] instanceof  DrinksOrder)
                            System.out.println(((DrinksOrder)sequence[i]).getPriceOfDrinks());
            }
            if (choice == 6) {
                for (int i = 0; i < sequence.length; i++) {
                    if (sequence[i] != null) {
                        System.out.println(sequence[i]);
                    }
                }
            }
            if (choice == 7 ) {
                setBills();
            }
            if (choice == 8 ) {
                triggerMethod();
            }
            if (choice == 9){
                IOOut.deleteReport();
                totalBills();
                numberOfOrder();
                numberOfSoldItem();
                maxOrder();
                minOrder();
                upperAverage();
                System.out.print("\n>> done.\n");
            }
            if (choice == 10) {
                System.out.print("we are now update report file...");
                IOOut.deleteReport();
                totalBills();
                numberOfOrder();
                numberOfSoldItem();
                maxOrder();
                minOrder();
                upperAverage();
                System.out.print("\nplease be patient until we save all change...");
                IOOut.checkToSaveAll();
                for (int i=0;i<sequence.length;i++){
                    if (sequence[i] != null)
                        IOOut.write(sequence[i]);
                }
                System.out.println("\nGood bye...");
                System.exit(0);
            }
            yesNo = inputYesNoChoice();
            if (yesNo.equalsIgnoreCase("n")) {
                System.out.print("we are now update report file...");
                IOOut.deleteReport();
                totalBills();
                numberOfOrder();
                numberOfSoldItem();
                maxOrder();
                minOrder();
                upperAverage();
                System.out.print("\nplease be patient until we save all change...");
                IOOut.checkToSaveAll();
                for (int i=0;i<sequence.length;i++){
                    if (sequence[i] != null)
                        IOOut.write(sequence[i]);
                }
                System.out.println("\nThank you ...");
                break;
            }
        }while (yesNo.equalsIgnoreCase("y"));
    }
}
