package entity;

import jakarta.persistence.*;

@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String collectionName;

    public Collection() {

    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", collectionName='" + collectionName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collection collection = (Collection) o;

        if (id != null ? !id.equals(collection.id) : collection.id != null) return false;
        return collectionName != null ? collectionName.equals(collection.collectionName) : collection.collectionName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (collectionName != null ? collectionName.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Collection(String collectionName) {
        this.collectionName = collectionName;
    }
}