package team.globaloptima;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deliveryperson")
@NamedQueries({
        @NamedQuery(
                name = "DeliveryPerson.findDeliveryPerson",
                query = "SELECT d FROM DeliveryPerson d"
        )
})
public class DeliveryPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "transportId")
    private String transportId;

    @Column(name = "currentAddress")
    private String currentAddress;
    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }
}
