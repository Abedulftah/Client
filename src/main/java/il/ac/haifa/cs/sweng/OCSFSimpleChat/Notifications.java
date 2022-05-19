package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import javafx.scene.Node;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notifications")
public class Notifications implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "notification")
    private String notification;
    @Column(name = "response")
    private String response;
    @Column(name = "date")
    private String date;

    public Notifications() {}

    public Notifications(String email, String notification, String response, String date) {

        this.email = email;
        this.notification = notification;
        this.response = response;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
