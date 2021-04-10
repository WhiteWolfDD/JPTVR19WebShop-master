package entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Double price;
    private Integer count;
    private Integer height;
    private Integer width;
    private Integer depth;
    private Integer seat_height;
    private Integer seat_depth;
    private Integer sleeping_area_width;
    private Integer sleeping_area_length;
    private Integer delivery_time;
    private Double delivery_price;
    private Integer guarantee;
    private String sleeping_function;
    private String legs;
    private String bedding_box;
    private String color_selection;
    private String materials;
    private String resistance;
    private String origin;
    @OneToOne
    private Cover cover;
    @OneToOne
    private Collection collection;

    public Product() {
    }

    public Product(String model, Double price, Integer count, Integer height, Integer width, Integer depth, Integer seat_height, Integer seat_depth, Integer sleeping_area_width, Integer sleeping_area_length, Integer delivery_time, Double delivery_price, Integer guarantee, String sleeping_function, String legs, String bedding_box, String color_selection, String materials, String resistance, String origin, Cover cover, Collection collection) {
        this.model = model;
        this.price = price;
        this.count = count;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.seat_height = seat_height;
        this.seat_depth = seat_depth;
        this.sleeping_area_width = sleeping_area_width;
        this.sleeping_area_length = sleeping_area_length;
        this.delivery_time = delivery_time;
        this.delivery_price = delivery_price;
        this.guarantee = guarantee;
        this.sleeping_function = sleeping_function;
        this.legs = legs;
        this.bedding_box = bedding_box;
        this.color_selection = color_selection;
        this.materials = materials;
        this.resistance = resistance;
        this.origin = origin;
        this.cover = cover;
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", seat_height=" + seat_height +
                ", seat_depth=" + seat_depth +
                ", sleeping_area_width=" + sleeping_area_width +
                ", sleeping_area_length=" + sleeping_area_length +
                ", delivery_time=" + delivery_time +
                ", delivery_price=" + delivery_price +
                ", guarantee=" + guarantee +
                ", sleeping_function='" + sleeping_function + '\'' +
                ", legs='" + legs + '\'' +
                ", bedding_box='" + bedding_box + '\'' +
                ", color_selection='" + color_selection + '\'' +
                ", materials='" + materials + '\'' +
                ", resistance='" + resistance + '\'' +
                ", origin='" + origin + '\'' +
                ", cover=" + cover +
                ", collection=" + collection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (count != null ? !count.equals(product.count) : product.count != null) return false;
        if (height != null ? !height.equals(product.height) : product.height != null) return false;
        if (width != null ? !width.equals(product.width) : product.width != null) return false;
        if (depth != null ? !depth.equals(product.depth) : product.depth != null) return false;
        if (seat_height != null ? !seat_height.equals(product.seat_height) : product.seat_height != null) return false;
        if (seat_depth != null ? !seat_depth.equals(product.seat_depth) : product.seat_depth != null) return false;
        if (sleeping_area_width != null ? !sleeping_area_width.equals(product.sleeping_area_width) : product.sleeping_area_width != null)
            return false;
        if (sleeping_area_length != null ? !sleeping_area_length.equals(product.sleeping_area_length) : product.sleeping_area_length != null)
            return false;
        if (delivery_time != null ? !delivery_time.equals(product.delivery_time) : product.delivery_time != null)
            return false;
        if (delivery_price != null ? !delivery_price.equals(product.delivery_price) : product.delivery_price != null)
            return false;
        if (guarantee != null ? !guarantee.equals(product.guarantee) : product.guarantee != null) return false;
        if (sleeping_function != null ? !sleeping_function.equals(product.sleeping_function) : product.sleeping_function != null)
            return false;
        if (legs != null ? !legs.equals(product.legs) : product.legs != null) return false;
        if (bedding_box != null ? !bedding_box.equals(product.bedding_box) : product.bedding_box != null) return false;
        if (color_selection != null ? !color_selection.equals(product.color_selection) : product.color_selection != null)
            return false;
        if (materials != null ? !materials.equals(product.materials) : product.materials != null) return false;
        if (resistance != null ? !resistance.equals(product.resistance) : product.resistance != null) return false;
        if (origin != null ? !origin.equals(product.origin) : product.origin != null) return false;
        if (cover != null ? !cover.equals(product.cover) : product.cover != null) return false;
        return collection != null ? collection.equals(product.collection) : product.collection == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        result = 31 * result + (seat_height != null ? seat_height.hashCode() : 0);
        result = 31 * result + (seat_depth != null ? seat_depth.hashCode() : 0);
        result = 31 * result + (sleeping_area_width != null ? sleeping_area_width.hashCode() : 0);
        result = 31 * result + (sleeping_area_length != null ? sleeping_area_length.hashCode() : 0);
        result = 31 * result + (delivery_time != null ? delivery_time.hashCode() : 0);
        result = 31 * result + (delivery_price != null ? delivery_price.hashCode() : 0);
        result = 31 * result + (guarantee != null ? guarantee.hashCode() : 0);
        result = 31 * result + (sleeping_function != null ? sleeping_function.hashCode() : 0);
        result = 31 * result + (legs != null ? legs.hashCode() : 0);
        result = 31 * result + (bedding_box != null ? bedding_box.hashCode() : 0);
        result = 31 * result + (color_selection != null ? color_selection.hashCode() : 0);
        result = 31 * result + (materials != null ? materials.hashCode() : 0);
        result = 31 * result + (resistance != null ? resistance.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (collection != null ? collection.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getSeat_height() {
        return seat_height;
    }

    public void setSeat_height(Integer seat_height) {
        this.seat_height = seat_height;
    }

    public Integer getSeat_depth() {
        return seat_depth;
    }

    public void setSeat_depth(Integer seat_depth) {
        this.seat_depth = seat_depth;
    }

    public Integer getSleeping_area_width() {
        return sleeping_area_width;
    }

    public void setSleeping_area_width(Integer sleeping_area_width) {
        this.sleeping_area_width = sleeping_area_width;
    }

    public Integer getSleeping_area_length() {
        return sleeping_area_length;
    }

    public void setSleeping_area_length(Integer sleeping_area_length) {
        this.sleeping_area_length = sleeping_area_length;
    }

    public Integer getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Integer delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Double getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(Double delivery_price) {
        this.delivery_price = delivery_price;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public String getSleeping_function() {
        return sleeping_function;
    }

    public void setSleeping_function(String sleeping_function) {
        this.sleeping_function = sleeping_function;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getBedding_box() {
        return bedding_box;
    }

    public void setBedding_box(String bedding_box) {
        this.bedding_box = bedding_box;
    }

    public String getColor_selection() {
        return color_selection;
    }

    public void setColor_selection(String color_selection) {
        this.color_selection = color_selection;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}