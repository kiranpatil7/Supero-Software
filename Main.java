import java.util.*;
import java.io.* ;
//Considering price is Double Value and Quantity is Duuble;
public class Main  extends Item {
        static  BufferedReader sc=new BufferedReader(new InputStreamReader(System.in)); 
    

    public static void main(String[] args){

       
        char choice;
        String name =null,type=null;
        double total_price=0.00, per_tax=0.00,price=0.00;
        double quantity=0.0;
        try{
             int length = args.length;
             if(length<1 || length>8)
             {
                 throw new ExceptionHandle("Pass required number of parameter\n");
             }
            for(int i=0;i<length;i++)
        {
            if(i==length-1)
            {

                while(true)
                {
                         System.out.println("Do you want to enter details of any other item (y/n):");
                    try
                    {
                        choice = sc.readLine().toLowerCase().charAt(0);
                        if(choice=='y')
                        {
                            addItem();
                        }
                        else if(choice=='n'){
                            break;
                        }

                    }
                    catch(Exception e)
                    {
                        System.out.println("Please Enter the character value only\n");
                    }


                }

            }
        
            else if(args[i].toLowerCase().equals("name"))
            {
                System.out.println("From Name");

                boolean checkingtype =false;
                
                    checkingtype =isNumric(args[i+1]);
                    if(checkingtype)
                    {
                        throw new ExceptionHandle("Item Name should be String \n");
                    }
                    else
                    {
                        name = args[i+1].toLowerCase();
                    }
            }
            else if(args[i].toLowerCase().equals("type"))
            {
                System.out.println("From Type");

                boolean checkingtype =false;
                
                    checkingtype =isNumric(args[i+1]);
                    if(checkingtype)
                    {
                        throw new ExceptionHandle("Item type should be String \n");
                    }
                    else
                    {
                        type = args[i+1].toLowerCase();

                    }

            }
            else if(args[i].toLowerCase().equals("price"))
            {
                System.out.println("From Price");

                boolean checkingtype =false;
                
                    checkingtype =isNumric(args[i+1]);
                    if(checkingtype)
                    {
                        price = Double.parseDouble(args[i+1]);

                    }
                    else
                    {
                        throw new ExceptionHandle("Item price should be Number \n");
                    }

            }
            else if(args[i].toLowerCase().equals("quantity"))
            {
                boolean checkingtype =false;
                
                    checkingtype =isNumric(args[i+1]);
                    System.out.println("From Quantity"+checkingtype);

                    if(checkingtype)
                    {

                        quantity= Double.parseDouble(args[i+1]);
                        

                    }
                    else
                    {
                        throw new ExceptionHandle("Item quantity should be integer Number \n");
                    }

            }
           
            
        }

        if(type.equals("raw"))
        {
            per_tax= 0.125*price;
            total_price = per_tax*quantity;
           // System.out.println("Per-Tax"+per_tax);


        }else if(type.equals("manufactured")){
             per_tax =((0.125*price) + (0.02*(price+0.125*price)));
             total_price =per_tax*quantity;

        }else if (type.equals("imported")){


        }else{
            throw new ExceptionHandle("You can set type of item  Raw, Manufactured and Imported\n");
        }

        Item item = new Item();
            item.setName(name);
            item.setTotalPrice(total_price);
            item.setType(type);
            item.setPerItemTax(per_tax);
            item.setItem(item);

        }catch(ExceptionHandle e)
        {
            System.out.println(e);
        }

        



        displayItem();
       

       
        
        

       // showMenu();

    }

    // public static void showMenu()
    // {
    //     while(true)
    //     {
    //         System.out.println("1: Add Items");
    //         System.out.println("2: DisplayItems");
    //         System.out.println("3: Exit");

    //         int choice =0;
    //         try{
    //             choice = sc.nextInt();

    //         }catch(Exception e)
    //         {
    //             System.out.println("Enter the Number");
    //             return;
    //         }
    //         switch(choice)
    //         {
    //             case 1:
    //                     addItem();
    //                     while(true)
    //                     {
    //                         try{

    //                             System.out.println("Do you want to enter details of any other item (y/n):");
    //                         char option =sc.next().toLowerCase().charAt(0);
    //                         if(option=='y')
    //                         {
    //                             addItem();
    //                         }
    //                         else
    //                         {
    //                             break;
    //                         }
    //                         }
    //                         catch(Exception e)
    //                         {
    //                             System.out.println(e);
    //                         }
                            
    //                     }
                        
                        
    //                     break;
    //             case 2:displayItem(); break;
    //             case 3:System.exit(1);
    //         }
    //     }
    // }

    //Method to add Items
    public static void addItem()throws Exception
    {
       // BufferedReader sc=new BufferedReader(new InputStreamReader(System.in)); 

        try{
            System.out.println("Enter the Item Name");
            String name =sc.readLine().toLowerCase();
            System.out.println("Enter the item Price");
            double price =Double.parseDouble(sc.readLine());
            System.out.println("Enter the item Quantity");
            double quntity =Double.parseDouble(sc.readLine());
            System.out.println("Enter the Type of Item(Raw, Manufactured, Imported)");
            String type = sc.readLine().toLowerCase();
            double total_price,per_tax;
            if(type.equals("raw"))
            {
                per_tax= 0.125*price;
                total_price =per_tax*quntity;

            }
            else if(type.equals("manufactured"))
            {
                per_tax =((0.125*price) + (0.02*(price+0.125*price)));
                total_price =per_tax*quntity;

            }
            else{
                per_tax =0;
                total_price =0;
            }

           
            Item item = new Item();
            item.setName(name);
            item.setTotalPrice(total_price);
            item.setType(type);
            item.setPerItemTax(per_tax);
            item.setItem(item);

        }catch(Exception e)
        {
            System.out.println(e);
        }        

            


        }

    public static  void displayItem()
    {
                    Item item = new Item();

                    item.getItem();

    }

    public static  boolean isNumric(String check)
    {
        if(check ==null)
        {
            return false;
        }
        try{
            double d=Double.parseDouble(check);


        }catch(Exception e){
            return false;
        }
        return true;
    }
}
