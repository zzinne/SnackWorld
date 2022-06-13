import java.util.ArrayList;
import java.util.List;

public class Products {
    List<Item> itemList = new ArrayList<Item>();

    public void addItem(String id, String name, int amount){
        itemList.add(new Item(id, name, amount));
    }
    public void removeItem(String name){
        itemList.removeIf(item -> item.name.equals(name));
    };
}
