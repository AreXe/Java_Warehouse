/*System zarządzania magazynem
  1. Wprowadzenie
  2. Pierwszy program
  3. Zmienne
  4. Klasy
  5. Wczytywanie danych od użytkownika
  6. Instrukcja warunkowa IF
  7. Pętla for
  8. Obiektowość w praktyce

  Ad. 3 Zmienne
  a) Oparte o typy proste:
  int number = 0;
  double liczba = 1.2321;
  b) Oparte o klasy:
  String haslo = "CoTuSieWydarzylo??"

  Ad. 4 Klasy vs obiekty
  a) Klasa: typ danych, "szablon", definicja obiektów; opisuje...
  b) Obiekt: ...

  Stworzenie obiektu:
  Scanner scanner = new Scanner(System.in); - argument określający skąd mają być wczytane dane, z klawiatury

  Wczytanie tekstu:
  String choice = scanner.next(); - wywołanie metody wczytującej dane z klawiatury

  Ad. 6 Instrukcja warunkowa "if"
  if ( warunek) {
  = kod wykonywany jeśli warunek jest spełniony
  } else {
   = kod wykonywany jeśli warunek NIE jest spełniony
  }

  Ad. 7 Pętla for
  for (int i = 0; i < 10; i++) {
    = kod, który wykona się 10 razy, kolejno: inicjalizacja licznika pętli (raz), warunek zakończenia pętli (sprawdzany zawsze), aktualizacja licznika pętli (wykonywana zawsze na końcu)
  }
*/

import java.util.Scanner;

public class Main { /*Nazwa głównej klasy, otwiera cały program*/

    public static void main(String[] args) { /* klasa Javy, void = typ zwracany przez metodę, main = nazwa metody */

        String tytul = "Aplikacja do zarządzania magazynem"; // zmienna przechowująca tekst; String = typ zmiennej, tytul = nazwa zmiennej
        System.out.println(tytul); // wypisywanie tekstu

        Product apples = new Product ("Jabłka Ligol",  500, 0.05,  1.6);

        /* Deklaracja produktu "jabłka" - bez klasy "product" (tablica), czyli wszystko ładujemy ręcznie w funkcji "Main"
        String appleName = "Jabłka Ligol";
        int appleKilograms = 500;
        double grossPricePerKilo = 1.6;
        double vatRate = 0.05;
        double netPricePerKilo = grossPricePerKilo*(1-vatRate);*/
        double netPricePerKilo = apples.calculateNetPricePerUnit(); //przywołujemy obiekt "apples" z klasy "Product" i funkcję apples.FUNKCJA

        //showWarehouseState(appleName, appleKilograms, grossPricePerKilo, netPricePerKilo); //sytuacja jw.
        showWarehouseState(apples.name, apples.amount, apples.grossPricePerUnit, netPricePerKilo);

        // Product apples = new Product(appleName, appleKilograms, vatRate, grossPricePerKilo); //sytuacja jw.
        System.out.println("Nazwa produktu: " + apples.name);

        showMenu(); //wywołanie funkcji showMenu - jak nazwa wskazuje, pokazuje menu programu

        Scanner scanner = new Scanner(System.in); //utworzenie obiektu Scanner - do otrzymywania poleceń od użytkownika z klawiatury
        String choice = scanner.next();

        if(choice.equals("1")) {
            //double allProductGrossPrice = calculateAllProductsGrossPrice(appleKilograms, grossPricePerKilo);
            double allProductGrossPrice = calculateAllProductsGrossPrice(apples.amount, apples.grossPricePerUnit);
            System.out.println("Cena brutto wszystkich towarów: " + allProductGrossPrice);
        } else {
            if(choice.equals("2")) {
                System.out.println("Podaj ilość dni:");
                int days = scanner.nextInt();
                double rentalCost = calculateColdStoreRentalCost(days);
                System.out.println("Koszt wynajęcia: " + rentalCost + "zł");
            }
        }
    }

// tutaj jest kod pozostałych funkcji, które można przywoływać do funkcji Main
    public static void showWarehouseState(String name, int appleKilograms, double grossPricePerKilo, double netPricePerKilo)
    {
        System.out.println("Stan magazynu:");
        System.out.println(name + ", ilość: " + appleKilograms + ", cena brutto: " + grossPricePerKilo + "zł " + ", cena netto: " + netPricePerKilo + "zł");
    }

    public static void showMenu()
    {
        System.out.println("Wybierz opcję");
        System.out.println("1 - oblicz cenę brutto wszystkich towarów");
        System.out.println("2 - oblicz koszt wynajmu chłodni");
    }

    public static double calculateAllProductsGrossPrice(int kilograms, double grossPricePerUnit) {
        double allProductsGrossPrice = kilograms*grossPricePerUnit;
        return allProductsGrossPrice;
    }

    public static double calculateColdStoreRentalCost(int days) {
        double dailyCost = 800;
        double discount = 0.01;
        double rentalCost = 0;
        for(int i = 0; i < days; i++) {
            rentalCost = rentalCost + dailyCost;
            dailyCost = dailyCost * (1 - discount);
        }
        return rentalCost;
    }
}