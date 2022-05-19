package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.Serializable;
import java.util.List;

public class MsgObject implements Serializable {
    private static final long serialVersionUID = -8224097662914849956L;
    String msg;
    Object object;
    int id;
    List<Catalog> catalogList;
    List<Notifications> notificationsList;
    public MsgObject() {
    }

    public MsgObject(String msg, Object object) {
        this.msg = msg;
        this.object = object;
    }

    public MsgObject(String msg) {
        this.msg = msg;
        this.object = null;
    }

    public MsgObject(String msg, int id) {
        this.msg = msg;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public List<Notifications> getNotificationsList() {
        return notificationsList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    public void setNotificationsList(List<Notifications> notificationsList) {
        this.notificationsList = notificationsList;
    }
}

