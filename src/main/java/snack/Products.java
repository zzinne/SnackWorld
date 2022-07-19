package snack;

import lombok.Getter;

import java.util.*;

@Getter
public class Products {
    public List<Item> itemList = new ArrayList<Item>();
    public static HashMap<String,Item> itemHashMap = new HashMap<>();


    public static void addItem(Item item) {
        String id = UUID.randomUUID().toString();
        itemHashMap.put(id, new Item(item.name, item.amount));
    }
    public static void removeItem(String id){
        itemHashMap.remove(id);
    };
    public void updateItem(String id,String name, int amount){
        itemHashMap.put(id,new Item(name, amount));
    };

    public static void selectItem(){
        for (Map.Entry<String,Item> value: itemHashMap.entrySet()){
            System.out.printf(" id: %s ,name: %s , amount:%d \n",value.getKey(),value.getValue().name,value.getValue().amount);
        }
    }
    public static String searchId(String name){
        String id ="";
        for (Map.Entry<String,Item> value : itemHashMap.entrySet()){
            if(value.getValue().name.equals(name)){
                id = value.getKey();
                break;
            }
        }
        return id;
    }
}
