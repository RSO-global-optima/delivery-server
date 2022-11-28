package team.globaloptima;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    public static List<DeliveryPerson> getDeliveryPeople() {
        return deliveryPeople;
    }

    public static DeliveryPerson getDeliveryPerson(Integer deliveryPersonId) {
        for (DeliveryPerson deliveryPerson : deliveryPeople) {
            if (deliveryPerson.getId().equals(deliveryPersonId))
                return deliveryPerson;
        }
        return null;
    }

    public static void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPeople.add(deliveryPerson);
    }

    public static void deleteDeliveryPerson(Integer deliveryPersonId) {
        for (DeliveryPerson deliveryPerson : deliveryPeople) {
            if (deliveryPerson.getId().equals(deliveryPersonId)) {
                deliveryPeople.remove(deliveryPerson);
                break;
            }
        }
    }
}
