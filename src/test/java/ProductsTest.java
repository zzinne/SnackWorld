import org.junit.Test;

import java.util.List;

public class ProductsTest {

    @Test
    public void ItemAddTest(){

        Products products = new Products();


        products.itemList.add(new Item("1","a",100));
        products.itemList.add(new Item("2","b",200));
        products.itemList.add(new Item("3","c",300));

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.price+",id:"+item.id);
        }

    }
    @Test
    public void ItemAddFunction(){

        Products products = new Products();


        products.addItem("1","a",100);
        products.addItem("2","b",200);
        products.addItem("3","c",300);

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.price+",id:"+item.id);
        }

    }

    @Test
    public void ItemRemoveTest(){

        Products products = new Products();


        products.addItem("1","a",100);
        products.addItem("2","b",200);
        products.addItem("3","c",300);

        products.itemList.removeIf(item -> item.name.equals("a"));

        for(Item item: products.itemList){
            System.out.println("name:"+item.name+",Price:"+item.price+",id:"+item.id);
        }

    }
}
