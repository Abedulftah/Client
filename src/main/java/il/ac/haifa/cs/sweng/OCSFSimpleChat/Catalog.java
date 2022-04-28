package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "catalog"
)
public class Catalog implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "item")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "item_details")
    private String itemDetails;
    @Column(name = "price")
    private double price;
    @Column(name = "size")
    private String size;
    //    @Column(name = "Quantity")
//    private int left;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private MyImage image;
    @Column(name = "imgUrl")
    private String imgUrl;

    public Catalog(String imgUrl, String name, double price, String details, String size, String color){
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
        this.itemDetails = details;
        this.color = color;
        this.size = size;
    }

    public Catalog(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getItemValue() {
        return price;
    }

//    public MyImage getImage() {
//        return image;
//    }

    public String getItemDetails() {
        return itemDetails;
    }

//    public void setImage(MyImage image) {
//        this.image = image;
//    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }
    //    public int getLeft() {
//        return left;
//    }

    //public void setLeft(int left) {
    //   this.left = left;
    //}

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
