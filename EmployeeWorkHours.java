//Write a Java program that accepts a list of employee
//work hours and returns the number of employees who
//worked more than 40 hours, exactly 40 hours, or less
//than 40 hours in a week, and the average hours worked
//per day for each group.

import java.util.ArrayList;
import java.util.List;
public class EmployeeWorkHours {
	public static void main(String[] args) {
        List<double[]> employeeWorkHours = new ArrayList<>();
        employeeWorkHours.add(new double[]{8, 8, 8, 8, 8}); 
        employeeWorkHours.add(new double[]{9, 8, 7, 8, 8}); 
        employeeWorkHours.add(new double[]{10, 9, 8, 7, 6}); 
        employeeWorkHours.add(new double[]{8, 8, 8, 8, 9}); 
        employeeWorkHours.add(new double[]{8, 7, 6, 6, 5}); 

    
        final int WEEKLY_HOURS = 40;

        int moreThan40 = 0;
        int exactly40 = 0;
        int lessThan40 = 0;
        double totalHoursMoreThan40 = 0;
        double totalHoursExactly40 = 0;
        double totalHoursLessThan40 = 0;

        for (double[] hours : employeeWorkHours) {
            double totalHours = 0;
            for (double hour : hours) {
                totalHours += hour;
            }

            if (totalHours > WEEKLY_HOURS) {
                moreThan40++;
                totalHoursMoreThan40 += totalHours;
            } else if (totalHours == WEEKLY_HOURS) {
                exactly40++;
                totalHoursExactly40 += totalHours;
            } else {
                lessThan40++;
                totalHoursLessThan40 += totalHours;
            }
        }

        
        double averageMoreThan40 = moreThan40 == 0 ? 0 : totalHoursMoreThan40 / moreThan40 / 5;
        double averageExactly40 = exactly40 == 0 ? 0 : totalHoursExactly40 / exactly40 / 5;
        double averageLessThan40 = lessThan40 == 0 ? 0 : totalHoursLessThan40 / lessThan40 / 5;

        System.out.println("Group\t\t\tEmployees Count\t\tAverage Hours Per Day");
        System.out.printf("More than 40 hours\t%d\t\t\t\t%.2f\n", moreThan40, averageMoreThan40);
        System.out.printf("Exactly 40 hours\t%d\t\t\t\t%.2f\n", exactly40, averageExactly40);
        System.out.printf("Less than 40 hours\t%d\t\t\t\t%.2f\n", lessThan40, averageLessThan40);
    }

}