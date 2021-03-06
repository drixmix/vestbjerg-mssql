package ModelLayer; 

import java.util.HashMap;
import java.util.Map;
public class ProductContainer
{
    // instance variables
    private HashMap<Integer, Product> productMap;
    public static ProductContainer instance;
    //Initialize constructor
    private ProductContainer(){
        productMap = new HashMap<Integer, Product>(); 
    }

    /**
     * laver en ProductContainer hvis der ikke er en og returnerer 
     * den nye eller den ekstisterende 
     */
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer(); 
        }
        return instance;
    }

    public void addProduct(Product product){
        productMap.put(product.getBarcode(), product);
    }

    /**
     * finder et produkt ved hjælp af barcode or returnerer den
     * @param int barcode 
     * @return Product 
     */
    public Product findProduct(int barcode){
        return productMap.get(barcode); 
    }

    /**
     * tjekker om varen er unik og returnerer en boolean 
     * @param int barcode
     * @return boolean 
     */
    public Boolean isUnique(int barcode){
        boolean type = false;
        if(findProduct(barcode) instanceof UniqueProduct){
            type = true;
        }
        return type;
    }

    /**
     * fjerner et uniqueItem fra et produkt og returnerer det
     * @param barcoden på et produkt og og et serienummer på et item  
     * @return et item objekt
     */
    public Item saleItem(int bar, int serial){
        return findProduct(bar).Sale(serial);
    }

    /**
     * trækker amount fra et massProduct og returnerer massProduktet 
     * @param barcoden på et produkt og mængden af det ønskede produkt 
     * @return et massproduct objekt 
     */
    public MassProduct saleProduct(int bar, int amount) throws NullPointerException {
        MassProduct findProduct = findProduct(bar).Sale(amount);
        if(findProduct == null){
            throw new NullPointerException();
        }
        return findProduct;
    }
    
    /**
     * henter prisen fra et item baseret på barcode 
     * @param et produkt barcode
     * @return price fra et produkt 
     */
    public double getPrice(int bar){
        return findProduct(bar).getPrice();    

    }
    
    public Map<Integer, Product> getmap() {
    return productMap;
    }
    
    public int getMax(int bar) {
    return findProduct(bar).getMaxAmount();
    }
    
    public void removeProduct(int bar) {
    productMap.remove(bar);	    
    }
    }

