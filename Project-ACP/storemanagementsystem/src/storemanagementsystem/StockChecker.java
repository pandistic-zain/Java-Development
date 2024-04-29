package storemanagementsystem;
public class StockChecker 
{
    private final static int threshold = 5;

    public static void checkAllProductsStockLevel() {
        for (int i = 0; i < ProductData.max; i++) {
            if (ProductData.p[i].getQty() <= threshold) 
            {
                System.out.println("Low stock alert: " + ProductData.p[i].getName() + " is running low in stock.");
            }
            
            
        }
        System.out.println("There is no Item with Low Stock  :) ");
    }
}