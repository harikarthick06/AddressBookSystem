public class Hotel {
    private String hotelName;
    private String hotelType;
    private int rating;
    private int weekdayRate;
    private int weekendRate;

    public Hotel(String hotelName, String hotelType, int rating,
                 int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.rating = rating;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelType() {
        return hotelType;
    }

    public int getRating() {
        return rating;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Name='" + hotelName + '\'' +
                ", Type='" + hotelType + '\'' +
                ", Rating=" + rating +
                ", Weekday Rate=" + weekdayRate +
                ", Weekend Rate=" + weekendRate +
                '}';
    }
}