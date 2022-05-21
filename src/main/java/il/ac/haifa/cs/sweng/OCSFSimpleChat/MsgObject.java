package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MsgObject implements Serializable {
    private static final long serialVersionUID = -8224097662914849956L;
    String msg;
    Object object;

    List<Catalog> catalogList = new ArrayList<>();
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

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

}

