package il.ac.haifa.cs.sweng.OCSFSimpleChat;

//we need an entity order to save a list of items, if a client want to order more than one item in the same order he can
//we need to take care of buy all in cart, buy an item and to take care of that we can pick items and buy them
//when we move from cart to order we need to remove all the catalogs that is sent to us by msgObject
//we do not need the date of each item, we need to put a date for the order
//we need
//the name of the order is the name of the client


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "order"
)
public class Order implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "numberOfItems")
    private int numberOfItems;
    @Column(name = "price")
    private String price;
    @Column(name = "shipping")
    private boolean shipping;

    @Column(name = "date")
    private String date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private SignUp user;



    public Order(SignUp user, int numberOfItems, String price, boolean shipping){
        this.user = user;
        this.numberOfItems = numberOfItems;
        this.price = price;
        this.shipping = shipping;
    }
    public Order(){}

    public SignUp getUser() {
        return user;
    }

    public void setUser(SignUp user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }
}
