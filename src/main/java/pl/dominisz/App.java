package pl.dominisz;

import pl.dominisz.Api.Library;
import pl.dominisz.Menu.Menu;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    private Library library;
    Scanner sc = new Scanner(System.in);

    public App(){
        library = new Library();
    }

    public void start(){
        library.load();
        mainMenu();
        library.save();
    }

    private Menu createMainMenu(){
        Menu menu = new Menu();

        menu.add("Dodaj nowa plyte",() -> addNewCd());
        menu.add("Usun plyte",() -> deleteCd());
        menu.add("Pokaz wszystkie plyty",() -> showAllCd());
        menu.add("Wyszukaj plyte po jej nazwie",() -> findCdByCdName());
        menu.add("Wyszukaj utwor po jego nazwie", () -> findTrackByTrackName());

        return menu;

    }

    private void findTrackByTrackName() {

    }

    private void findCdByCdName() {

    }

    private void showAllCd() {
        List cdList = library.getCdList();
        System.out.println("");
        for(int i = 0;i<cdList.size();i++){
            System.out.println((i+1) + "." + cdList.get(i));
        }
        System.out.println("");
    }

    private void deleteCd() {


    }

    private void addNewCd() {

    }

    private void mainMenu() {
        System.out.println("Witamy w Main Menu programu LibraryApp");
        boolean again = true;
        Menu mainMenu = createMainMenu();

        while (again){
            mainMenu.showMenuItemsMessage();
            System.out.println("");
            int option = readInt(mainMenu.size());
            mainMenu.runAction(option);

            }


    }

    private int readInt(int max) {
        int index;

        while(true) {
            System.out.println("Co chcesz zrobic?");
            String number = sc.nextLine();

                try {
                    index = Integer.parseInt(number);
                    if(index>0&&index<=max){
                        break;
                    }
                    else{
                        System.out.println("Podaj numer opcji");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Podaj numer opcji");
                }
        }
        return index;
    }

    private void showMenu() {
        System.out.println("1.Dodaj nową płytę");
        System.out.println("2.Usuń płytę");
        System.out.println("3.Wyświetl wszystkie płyty");
        System.out.println("4.Wyszukaj płyty po tytule płyty");
        System.out.println("5.Wyszukaj utwory po tytule utworu");
        System.out.println("6.Wyszukaj płyty po tytule utworu");
        System.out.println("7.Wyszukaj płyty po gatunku");
        System.out.println("8.Wyszukaj utwory po gatunku");
        System.out.println("9.Wyszukaj płty po roku wydania");
        System.out.println("10.Wyjdź z programu");
    }

    public static void main( String[] args ) {
        App app = new App();
        app.start();
        //dodaj nowa plyte
        //usun plyte
        //wyswietl wszystkie plyty
        //wyszukaj plyty po tytule
        //wyszukiwania
    }
}
