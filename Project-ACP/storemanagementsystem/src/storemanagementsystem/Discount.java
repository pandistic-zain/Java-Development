package storemanagementsystem;
class Discount 
{
  
    private String discount_name="200off";
    public int discountAmount=200;
    
    
    public void applydiscount(int newbill)
    {
        System.out.println(("Congratulation you got Discount :" ) + discount_name + ("\nYour new Bill is " + newbill ));
    }

    

    
}