import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MenuHandler implements Serializable {
    //Menu hashmaps/dictionaries created.
    Map<String, Integer> menu = new HashMap<>();
    Map<String, Integer> beveragesMenu = new HashMap<>();
    Map<String, Integer> alcoholBeveragesMenu = new HashMap<>();

    public void AddItem(String itemName, int price) {
        //add food item to regular menu (food item indicated by the lack of a third parameter)
        this.menu.put(itemName, price);
    }

    public void AddItem(String itemName, int price, boolean alcohol) {
        //add drink to one of the drink menus.
        if(!alcohol){
            this.beveragesMenu.put(itemName, price);
        } else{
            this.alcoholBeveragesMenu.put(itemName, price);
        }


    }


}
