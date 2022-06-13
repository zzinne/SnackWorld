import java.util.ArrayList;
import java.util.List;

public class Products {
    List<Item> itemList = new ArrayList<Item>();

    public void addItem(String id, String name, int price){
        itemList.add(new Item(id, name, price));
    }
    public void removeItem(String name){
        itemList.removeIf(item -> item.name.equals(name));
    };
}
