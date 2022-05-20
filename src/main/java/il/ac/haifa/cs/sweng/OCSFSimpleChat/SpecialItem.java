package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "specialItem"
)
public class SpecialItem implements Serializable{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(name = "container")
    private String container;

    @Column(name = "Flowers_Number")
    private int numOfFlowers;

    @Column(name = "chocolates")
    private Boolean chocolates;

    @Column(name = "bear")
    private Boolean teddyBeer;

    @Column(name = "message")
    private Boolean thereIsMessage;

    @Column(name = "flowerTypes")
    private String flowerTypes;

    @Column(name = "flowersIsNotIn")
    private String flowersIsNotIn;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private String price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private SignUp user;

    public SpecialItem(){}

    public SpecialItem(String container, int numOfFlowers, Boolean chocolates, Boolean teddyBeer, Boolean thereIsMessage, String flowerType, String flowersIsNotIn, String price, String color, SignUp user){
        this.container = container;
        this.numOfFlowers = numOfFlowers;
        this.chocolates = chocolates;
        this.teddyBeer = teddyBeer;
        this.thereIsMessage = thereIsMessage;
        this.flowerTypes = flowerType;
        this.flowersIsNotIn = flowersIsNotIn;
        this.price = price;
        this.color = color;
        this.user = user;

    }

    public SignUp getUser() {
        return user;
    }

    public Boolean getChocolates() {
        return chocolates;
    }

    public Boolean getTeddyBeer() {
        return teddyBeer;
    }

    public Boolean getThereIsMessage() {
        return thereIsMessage;
    }

    public int getNumOfFlowers() {
        return numOfFlowers;
    }

    public String getColor() {
        return color;
    }

    public String getContainer() {
        return container;
    }

    public String getFlowersIsNotIn() {
        return flowersIsNotIn;
    }

    public String getFlowerTypes() {
        return flowerTypes;
    }

    public String getPrice() {
        return price;
    }

    public void setThereIsMessage(Boolean thereIsMessage) {
        this.thereIsMessage = thereIsMessage;
    }
}
