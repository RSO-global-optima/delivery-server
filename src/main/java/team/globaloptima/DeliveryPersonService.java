package team.globaloptima;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@RequestScoped
public class DeliveryPersonService {

    @PersistenceContext(unitName = "team-globaloptima-delivery-person")
    private EntityManager em;

    public DeliveryPerson getDeliveryPerson(Integer deliveryPersonId) {
        return em.find(DeliveryPerson.class, deliveryPersonId);
    }

    public List<DeliveryPerson> getDeliveryPeople() {
        List<DeliveryPerson> deliveryPeople = em
                .createNamedQuery("DeliveryPerson.findDeliveryPerson", DeliveryPerson.class)
                .getResultList();
        return deliveryPeople;
    }

    @Transactional
    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        if (deliveryPerson != null) {
            em.persist(deliveryPerson);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteDeliveryPerson(Integer deliveryPersonId) {
        DeliveryPerson deliveryPerson = em.find(DeliveryPerson.class, deliveryPersonId);
        if (deliveryPerson != null) {
            em.remove(deliveryPerson);
        }
    }
}