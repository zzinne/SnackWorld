import org.junit.Test;
import snack.Item;
import snack.Products;

import java.util.HashMap;
import java.util.Map;

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

        //products.addItem("a",100);
        //products.addItem("b",200);
        //products.addItem("c",300);

        for (Map.Entry<String,Item> value: products.itemHashMap.entrySet()){
            System.out.printf(" id: %s ,name: %s , amount:%d \n",value.getKey(),value.getValue().name,value.getValue().amount);
        }
    }
    @Test
    public void ItemHashUpdateTest(){

        Products products = new Products();

        //products.addItem("a",100);
        //products.addItem("b",200);
        //products.addItem("c",300);

        for (Map.Entry<String,Item> value: products.itemHashMap.entrySet()){
            System.out.printf(" id: %s ,name: %s , amount:%d \n",value.getKey(),value.getValue().name,value.getValue().amount);
        }

        String updateId = products.searchId("a");
        products.updateItem(updateId,"updateA",500);

        for (Map.Entry<String,Item> value: products.itemHashMap.entrySet()){
            System.out.printf(" id: %s ,name: %s , amount:%d \n",value.getKey(),value.getValue().name,value.getValue().amount);
        }
    }
    @Test
    public void ItemHashRemoveTest(){

        Products products = new Products();

        //products.addItem("a",100);
        //products.addItem("b",200);
        //products.addItem("c",300);


        String deleteId = products.searchId("a");
        products.removeItem(deleteId);

        for (Map.Entry<String,Item> value: products.itemHashMap.entrySet()) {
            System.out.printf(" id: %s ,name: %s , amount:%d \n",value.getKey(),value.getValue().name,value.getValue().amount);
        }

        }
}
