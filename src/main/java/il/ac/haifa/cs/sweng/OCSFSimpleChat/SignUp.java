package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "signup"
)
public class SignUp implements Serializable{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "credit_card_holder")
    private String holderOfCard;

    @Column(name = "date_credit_card")
    private String date;

    @Column(name = "cvv")
    private int cvv;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialitem_id")
    private List<SpecialItem> specialItems;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "complains_id")
    private List<Complain> complains;

    public SignUp(String accountType, String username, String email, String phone, String password, String address, String creditCard, String holderOfCard, String date, int cvv){
        this.accountType = accountType;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.creditCard = creditCard;
        this.holderOfCard = holderOfCard;
        this.date = date;
        this.cvv = cvv;
    }

    public SignUp(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getHolderOfCard() {
        return holderOfCard;
    }

    public void setHolderOfCard(String holderOfCard) {
        this.holderOfCard = holderOfCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
