package snack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Products {
    List<Item> itemList = new ArrayList<Item>();
    HashMap<String,Item> itemHashMap = new HashMap<>();



    public void addItem(String id ,String name, int amount) {
        itemHashMap.put(id, new Item(name, amount));
    }
    public void removeItem(String id){
        itemHashMap.remove(id);
    };
    public void updateItem(String id,String name, int amount){
        itemHashMap.put(id,new Item(name, amount));
    };

    public void selectItem(){
        for(Item item:itemHashMap.values()){
            System.out.printf("name: %s , amount:%d \n",item.name,item.amount);
        }
    }
}
