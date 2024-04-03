//Write a Java program that accepts a list of medical test
//results and returns the number of patients with results
//falling within specific ranges (e.g., normal, borderline,
//high), and the average value for each range.

import java.util.Arrays;
import java.util.List;
public class MedicalTest {
	public static void main(String[] args) {
        List<Double> testResults = Arrays.asList(80.0, 90.0, 110.0, 130.0, 85.0, 105.0, 120.0);

        double normalRangeStart = 70.0;
        double normalRangeEnd = 100.0;
        double borderlineRangeStart = 100.0;
        double borderlineRangeEnd = 120.0;

        int normalCount = 0;
        int borderlineCount = 0;
        int highCount = 0;
        double normalTotal = 0.0;
        double borderlineTotal = 0.0;
        double highTotal = 0.0;

        for (Double result : testResults) {
            if (result >= normalRangeStart && result < normalRangeEnd) {
                normalCount++;
                normalTotal += result;
            } else if (result >= borderlineRangeStart && result < borderlineRangeEnd) {
                borderlineCount++;
                borderlineTotal += result;
            } else {
                highCount++;
                highTotal += result;
            }
        }

        double normalAverage = normalCount == 0 ? 0 : normalTotal / normalCount;
        double borderlineAverage = borderlineCount == 0 ? 0 : borderlineTotal / borderlineCount;
        double highAverage = highCount == 0 ? 0 : highTotal / highCount;

        System.out.println("Result Range\t\tPatients Count\t\tAverage Value");
        System.out.printf("Normal (%.2f-%.2f)\t\t%d\t\t\t%.2f\n", normalRangeStart, normalRangeEnd, normalCount, normalAverage);
        System.out.printf("Borderline (%.2f-%.2f)\t%d\t\t\t%.2f\n", borderlineRangeStart, borderlineRangeEnd, borderlineCount, borderlineAverage);
        System.out.printf("High (>%f)\t\t\t%d\t\t\t%.2f\n", borderlineRangeEnd, highCount, highAverage);
    }
}