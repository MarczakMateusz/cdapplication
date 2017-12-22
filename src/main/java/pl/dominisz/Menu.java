package pl.dominisz;

import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList;

    public Menu(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    private void MenuItem(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    private void add(String message, Runnable action){
        menuItemList.add(new MenuItem(message,action));
    }
    private void showMenuItemsMessage(){
        for(int i = 0;i < menuItemList.size();i++){
            System.out.println(i+1 + menuItemList.get(i).getMessage());
        }
    }

    private void runAction(int index){
        index--;
        if(index >= 0 && index<menuItemList.size()){
            menuItemList.get(index).getAction().run();
        }
    }
}
