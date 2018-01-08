package pl.dominisz;

import org.junit.jupiter.api.Test;
import pl.dominisz.Menu.Menu;

public class MenuTest {

    @Test
     void testMenu(){
        Menu menu = new Menu();
        menu.add("Piesek",() -> System.out.println("hau hau"));
        menu.add("Kotek",() -> System.out.println("mial mial"));
        menu.add("Krowa", new Sumator());
        menu.showMenuItemsMessage();
        menu.runAction(3);
    }
}
