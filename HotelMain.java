public class HotelMain {
    public static void main(String[] args) {

        HotelReservation reservation = new HotelReservation();

        reservation.addHotel(new Hotel("Lakewood", "Regular", 3, 110, 90));
        reservation.addHotel(new Hotel("Bridgewood", "Regular", 4, 160, 60));
        reservation.addHotel(new Hotel("Ridgewood", "Regular", 5, 220, 150));
        reservation.addHotel(new Hotel("Royal Palace", "Reward", 5, 100, 80));
        reservation.addHotel(new Hotel("City Inn", "Reward", 4, 90, 70));

        System.out.println("\nSearch Hotel By Name: Lakewood");
        reservation.display(reservation.searchHotelByName("Lakewood"));

        System.out.println("\nHotels With Rating 4 And Above");
        reservation.display(reservation.filterByRating(4));

        System.out.println("\nRegular Hotels");
        reservation.display(reservation.filterByType("Regular"));

        System.out.println("\nSort By Weekday Rate");
        reservation.display(reservation.sortByWeekdayRate());

        System.out.println("\nSort By Weekend Rate");
        reservation.display(reservation.sortByWeekendRate());

        System.out.println("\nSort By Rating High To Low");
        reservation.display(reservation.sortByRatingHighToLow());

        System.out.println("\nCount Regular Hotels");
        System.out.println(reservation.countByType("Regular"));

        System.out.println("\nCheapest Hotel");
        reservation.findCheapestHotel().ifPresent(System.out::println);

        System.out.println("\nBest Rated Hotel");
        reservation.findBestRatedHotel().ifPresent(System.out::println);
    }
}