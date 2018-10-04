/*
Klasa
Product

Konstruktor - pozwala utworzyć obiekt

Product(String name, double vatRate, int amount, double grossPricePerUnit) {
    this.name = name
    this.vatRate = vatRate;
    this.amount = amount;
    this.grossPricePerUnit = grossPricePerUnit;

Metody - wykonują logikę
*/
public class Product { /*Jakiś produkt w magazynie (Zastanawiamy się bardziej abstrakcyjnie i ogólnie)*/
    String name;
    int amount;
    double vatRate;
    double grossPricePerUnit;

    Product (String name, int amount, double vatRate, double grossPricePerUnit){ /*Tworzymy Konstruktor*/
        this.name = name;
        this.vatRate = vatRate;
        this.amount = amount;
        this.grossPricePerUnit = grossPricePerUnit;
    }

    public double calculateNetPricePerUnit() {
        double netPrice = grossPricePerUnit = (grossPricePerUnit * (1 - vatRate));
        return netPrice;
    }

    public double calculateTotalGrossValue() {
        double grossValue = grossPricePerUnit + amount;
        return grossValue;
    }
}

