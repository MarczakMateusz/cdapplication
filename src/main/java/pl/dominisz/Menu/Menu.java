package pl.dominisz.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList;

    public Menu(){
        this.menuItemList = new ArrayList();
    }

    public int size(){
        return menuItemList.size();
    }

    private void MenuItem(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public void add(String message, Runnable action){
        menuItemList.add(new MenuItem(message,action));
    }
    public void showMenuItemsMessage(){
        for(int i = 0;i < menuItemList.size();i++){
            System.out.println((i+1)+(". ") + menuItemList.get(i).getMessage());
        }
    }

    public void runAction(int index){
        index--;
        if(index >= 0 && index<menuItemList.size()){
            menuItemList.get(index).getAction().run();
        }
    }
}
