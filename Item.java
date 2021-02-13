import java.util.ArrayList;

class Item{
    private String item_Name;
    private String item_Type;
    private double item_Price;
    private double total_price;
    private double  per_tax;
    static ArrayList<Item> itemlist = new ArrayList<Item>();

    // Item(String name ,String type ,double price ,int quantity)
    // {
    //     item_Name = name;
    //     item_Type = type;
    //     item_Price = price;
    //     item_Quantity = quantity;

    // }

    public void setName(String name)
    {
        item_Name = name;
    }

    public String getName()
    {
        return item_Name;
    }
    
    public void setType(String type) {
        item_Type = type;
    }

    public String gettype() {
        return item_Type;
    }
    
    public void setPrice(double price) {
        item_Price = price;
    }

    public double getPrice() {
        return item_Price;
    }

    public void setTotalPrice (double finalPrice) {
        total_price = finalPrice;
    }

    public double getTotalPrice() {
        return total_price;
    }
    public void setPerItemTax (double tax) {
        per_tax= tax;
    }

    public double getPerItemTax () {
        return per_tax;
    }
     public static void setItem(Item item)
    {
        itemlist.add(item);
    }
    public static void getItem()
    {
        for(int i =0;i<itemlist.size();i++)
        {
                System.out.println("Item-Name ->"+itemlist.get(i).getName()+"\n"+"PerItemTax ->"+itemlist.get(i).getPerItemTax()+"\n"+"ItemTotalPrice ->"+itemlist.get(i).getTotalPrice()+"\n"+"Item-Type->"+itemlist.get(i).gettype());
                System.out.println(".........................................................................");
        }
    }

    


}