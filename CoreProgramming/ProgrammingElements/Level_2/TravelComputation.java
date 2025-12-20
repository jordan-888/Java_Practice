import java.util.Scanner;

public class TravelComputation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter from City, via City and to City: ");
        String fromCity = input.nextLine();
        String viaCity = input.nextLine();
        String toCity = input.nextLine();

        System.out.print("Enter distance between from City to via City and via City to final City (in miles): ");
        double distanceFromToVia = input.nextDouble();
        double distanceViaToFinal = input.nextDouble();

        System.out.print("Enter time taken between from City to via City and via City to final City (in hours): ");
        double timeFromToVia = input.nextDouble() * 60;
        double timeViaToFinal = input.nextDouble() * 60;

        double totalDistance = distanceFromToVia + distanceViaToFinal;
        double totalTime = timeFromToVia + timeViaToFinal;

        System.out.printf(
                "The total distance travelled by %s from %s to %s via %s is %.2f miles and the total time taken is %.2f minutes.%n",
                name, fromCity, toCity, viaCity, totalDistance, totalTime);
        input.close();
    }
}
