//Write a Java program that accepts a list of product sales and
//returns the number of products sold within specific price ranges
//(e.g., $0-50, $50-100, $100-200, etc.), and the total revenue
//generated within each price range.

import java.util.Arrays;
import java.util.List;

public class ProductSales 
{
	public static void main(String[] args) {
        List<Double> productSales = Arrays.asList(25.0, 60.0, 80.0, 110.0, 150.0, 180.0, 220.0);

        double[] priceRanges = {0, 50, 100, 200, Double.MAX_VALUE};

        int[] productCount = new int[priceRanges.length];
        double[] totalRevenue = new double[priceRanges.length];

        for (double salePrice : productSales) {
            for (int i = 0; i < priceRanges.length - 1; i++) {
                if (salePrice >= priceRanges[i] && salePrice < priceRanges[i + 1]) {
                    productCount[i]++;
                    totalRevenue[i] += salePrice;
                    break;                }
            }
        }

        System.out.println("Price Range\t\tProducts Sold\t\tTotal Revenue");
        for (int i = 0; i < priceRanges.length - 1; i++) {
            System.out.printf("$%.2f - $%.2f\t\t%d\t\t\t$%.2f\n", priceRanges[i], priceRanges[i + 1], productCount[i], totalRevenue[i]);
        }
    }
}