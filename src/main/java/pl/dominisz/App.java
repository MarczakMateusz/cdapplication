package pl.dominisz;

import java.util.ArrayList;
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

    private void mainMenu() {
        System.out.println("Witamy w Main Menu programu LibraryApp");
        boolean again = true;
        while (again){
            showMenu();
            int number = readInt(10);

            switch (number){
                case 1:
                    //addNewCd();
                    break;
                case 2:
                    //deleteCd();
                    break;
                case 3:
                    //showAllCd();
                    break;
                case 4:
                    //findCdByCdName();
                    break;
                case 5:
                    //findTrackByTrackName();
                    break;
                case 10:
                    again = false;
                    break;
            }

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
