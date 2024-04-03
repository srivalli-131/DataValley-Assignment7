//Write a Java program that accepts a list of housing
//prices and returns the number of houses sold within
//specific price ranges (e.g., $100,000-200,000,
//$200,000-300,000, etc.), and the average square footage
//for each price range.

import java.util.ArrayList;
import java.util.List;
public class HousingPrices {
	public static void main(String[] args) {
        List<HousingEntry> housingData = new ArrayList<>();
        housingData.add(new HousingEntry(150000, 1200)); 
        housingData.add(new HousingEntry(220000, 1400)); 
        housingData.add(new HousingEntry(180000, 1100)); 
        housingData.add(new HousingEntry(280000, 1600)); 
        housingData.add(new HousingEntry(200000, 1300)); 
        housingData.add(new HousingEntry(350000, 1800)); 
        housingData.add(new HousingEntry(400000, 2000)); 

        int[] priceRanges = {100000, 200000, 300000, 400000, Integer.MAX_VALUE};

        int[] houseCount = new int[priceRanges.length];
        double[] totalSquareFootage = new double[priceRanges.length];

        for (HousingEntry entry : housingData) {
            int price = entry.getPrice();
            double squareFootage = entry.getSquareFootage();

            for (int i = 0; i < priceRanges.length - 1; i++) {
                if (price >= priceRanges[i] && price < priceRanges[i + 1]) {
                    houseCount[i]++;
                    totalSquareFootage[i] += squareFootage;
                    break; 
                }
            }
        }

        double[] averageSquareFootage = new double[priceRanges.length];
        for (int i = 0; i < priceRanges.length - 1; i++) {
            averageSquareFootage[i] = houseCount[i] == 0 ? 0 : totalSquareFootage[i] / houseCount[i];
        }

        System.out.println("Price Range\t\tHouses Sold\t\tAverage Square Footage");
        for (int i = 0; i < priceRanges.length - 1; i++) {
            System.out.printf("$%d - $%d\t\t%d\t\t\t%.2f\n", priceRanges[i], priceRanges[i + 1], houseCount[i], averageSquareFootage[i]);
        }
    }
}

class HousingEntry {
    private int price;
    private double squareFootage;

    public HousingEntry(int price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public int getPrice() {
        return price;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

}