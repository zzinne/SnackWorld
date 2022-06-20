import org.junit.Test;
import snack.Item;
import snack.Products;

import java.util.HashMap;

public class ProductsTest {

    @Test
    public void ItemAddTest(){

        Products products = new Products();


        products.itemList.add(new Item("a",100));
        products.itemList.add(new Item("b",200));
        products.itemList.add(new Item("c",300));

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.amount);
        }

    }

    @Test
    public void ItemHashMapTest(){

        HashMap itemList = new HashMap<>();

        itemList.put(1,new Item("a",100));



    }
    @Test
    public void ItemAddFunction(){

        Products products = new Products();



        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.amount);
        }

    }

    @Test
    public void ItemRemoveTest(){

        Products products = new Products();



        products.itemList.removeIf(item -> item.name.equals("a"));

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.amount);
        }

    }
    @Test
    public void ItemUpdateTest(){

        Products products = new Products();



        //products.itemList.set()

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.amount);
        }

    }
    @Test
    public void ItemHashTest(){

        Products products = new Products();

        products.addItem("1","a",100);
        products.addItem("2","b",200);
        products.addItem("3","c",300);

        for (Item value: products.itemHashMap.values()){
            System.out.printf(" name: %s , amount:%d \n",value.name,value.amount);
        }
    }
    @Test
    public void ItemHashUpdateTest(){

        Products products = new Products();

        products.addItem("1","a",100);
        products.addItem("2","b",200);
        products.addItem("3","c",300);

        for (Item value:products.itemHashMap.values()){
            System.out.printf(" name: %s , amount:%d \n",value.name,value.amount);
        }

        products.addItem("2","update B",500);
        for (Item value:products.itemHashMap.values()){
            System.out.printf(" name: %s , amount:%d \n",value.name,value.amount);
        }
    }
    @Test
    public void ItemHashRemoveTest(){

        Products products = new Products();

        products.addItem("1","a",100);
        products.addItem("2","b",200);
        products.addItem("3","c",300);

        products.removeItem("2");
        for (Item value:products.itemHashMap.values()){
            System.out.printf("name: %s , amount:%d \n",value.name,value.amount);
        }


    }
}
