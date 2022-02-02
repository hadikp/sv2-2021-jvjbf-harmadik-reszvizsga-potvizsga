package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApartmentRental {

    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public List<Apartment> findApartmentByLocation(String location) {
        return apartments.stream().filter(f -> f.getLocation().equals(location)).collect(Collectors.toList());
    }

    public List<Apartment> findApartmentByExtras(String... extra) {
        List<Apartment> result = new ArrayList<>();
        //return apartments.stream().filter(f -> f.getExtras().equals(Stream.of(extra))
        /*for (String st: extra) {
            Apartment apartment = apartments.stream().filter(f ->f.getExtras().equals(extra)).findFirst().orElse();
            result.add(apartment);
        }*/
        return result;
    }

    public boolean isThereApartmentWithBathroomType(BathRoomType type) {
        return apartments.stream().anyMatch(f -> f.getBathRoomType().equals(type));
    }

    public List<Integer> findApartmentsSize() {
        return apartments.stream().map(Apartment::getSize).collect(Collectors.toList());
    }
}
