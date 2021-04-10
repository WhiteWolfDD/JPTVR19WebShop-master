package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

@Entity
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @OneToOne()
    private Product product;
    @OneToOne()
    private Buyer buyer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeOn;

    public History() {
    }


    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", product=" + product +
                ", buyer=" + buyer +
                ", takeOn=" + takeOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) && Objects.equals(status, history.status) && Objects.equals(product, history.product) && Objects.equals(buyer, history.buyer) && Objects.equals(takeOn, history.takeOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, product, buyer, takeOn);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getTakeOn() {
        return takeOn;
    }

    public void setTakeOn(Date takeOn) {
        this.takeOn = takeOn;
    }

    public History(String status, Product product, Buyer buyer, Date takeOn) {
        this.status = status;
        this.product = product;
        this.buyer = buyer;
        this.takeOn = takeOn;
    }
}