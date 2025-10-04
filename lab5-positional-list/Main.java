public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> trip = new LinkedPositionalList<>();

        var pAirport = trip.addLast("Airport");
        var pHotel   = trip.addLast("Hotel");
        var pMuseum  = trip.addLast("Museum");
        var pCafe    = trip.addLast("Cafe");

        trip.addAfter(pMuseum, "Art Gallery");

        System.out.println("First stop: " + trip.first().getElement());
        System.out.println("Last stop:  " + trip.last().getElement());
        System.out.println("Before Cafe: " + trip.before(pCafe).getElement());
        System.out.println("After Hotel:  " + trip.after(pHotel).getElement());

        trip.set(pAirport, "SJC Airport");

        trip.remove(pHotel);

        System.out.println("\nFinal itinerary (for-each):");
        for (String stop : trip) {
            System.out.println("- " + stop);
        }

        System.out.println("\nItinerary: " + trip);
    }
}
