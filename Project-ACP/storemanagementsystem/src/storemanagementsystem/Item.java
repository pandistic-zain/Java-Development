package storemanagementsystem;
public class Item implements Product 
{
    private String name;
    private int id;
    private int price;
     private int quantity;
          
     public Item() {
        // Constructor code here, if needed
    }
     
     public Item(int id, String name,int price, int quantity ) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    

    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public String getName() 
    {
        return name;
    }
     @Override
    public void setId(int id) 
    {
        this.id = id;
    }

    @Override
    public int getId() 
    {
        return id; 
    }
    @Override
    public void setPrice(int price) 
    {
        this.price = price;
    }

    @Override
    public int getPrice() 
    {
        return price;
    }
    @Override
    public void setQty(int quantity) 
    {
        this.quantity = quantity;
    }

    @Override
    public int getQty() 
    {
        return quantity;
    }
}

