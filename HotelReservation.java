import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {

    private List<Hotel> hotels = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        System.out.println("Hotel added: " + hotel.getHotelName());
    }

    // Search hotel by name
    public List<Hotel> searchHotelByName(String hotelName) {
        return hotels.stream()
                .filter(h -> h.getHotelName().equalsIgnoreCase(hotelName))
                .collect(Collectors.toList());
    }

    // Filter hotels by rating
    public List<Hotel> filterByRating(int rating) {
        return hotels.stream()
                .filter(h -> h.getRating() >= rating)
                .collect(Collectors.toList());
    }

    // Filter hotels by type
    public List<Hotel> filterByType(String type) {
        return hotels.stream()
                .filter(h -> h.getHotelType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Sort hotels by weekday rate
    public List<Hotel> sortByWeekdayRate() {
        return hotels.stream()
                .sorted(Comparator.comparing(Hotel::getWeekdayRate))
                .collect(Collectors.toList());
    }

    // Sort hotels by weekend rate
    public List<Hotel> sortByWeekendRate() {
        return hotels.stream()
                .sorted(Comparator.comparing(Hotel::getWeekendRate))
                .collect(Collectors.toList());
    }

    // Sort hotels by rating high to low
    public List<Hotel> sortByRatingHighToLow() {
        return hotels.stream()
                .sorted(Comparator.comparing(Hotel::getRating).reversed())
                .collect(Collectors.toList());
    }

    // Count hotels by type
    public long countByType(String type) {
        return hotels.stream()
                .filter(h -> h.getHotelType().equalsIgnoreCase(type))
                .count();
    }

    // Find cheapest hotel by weekday rate
    public Optional<Hotel> findCheapestHotel() {
        return hotels.stream()
                .min(Comparator.comparing(Hotel::getWeekdayRate));
    }

    // Find best rated hotel
    public Optional<Hotel> findBestRatedHotel() {
        return hotels.stream()
                .max(Comparator.comparing(Hotel::getRating));
    }

    public void display(List<Hotel> hotelList) {
        hotelList.forEach(System.out::println);
    }
}