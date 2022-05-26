package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.Shop;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class Histogram {

    @FXML // fx:id="Profit"
    private BarChart<?, ?> Profit; // Value injected by FXMLLoader

    @FXML // fx:id="x"
    private CategoryAxis x; // Value injected by FXMLLoader

    @FXML // fx:id="y"
    private NumberAxis y; // Value injected by FXMLLoader

    public void initialize() {
        //we need to change the name of the column and the title according to the wanted histogram
        String[] stringA = msgObject.getMsg().split(" ");

        y.setLabel(stringA[stringA.length-2]);
        Profit.setTitle(stringA[stringA.length-2]);

        List<Shop> shops = (List<Shop>) msgObject.getObject();
        List<Shop> shopList = new ArrayList<>();

        XYChart.Series set = new XYChart.Series<>();

        set.setName("shop " + stringA[stringA.length-1]);

        for(int j = 0; j < shops.size(); j++) {//bubble sort according to date
            for (int i = j + 1; i < shops.size(); i++) {
                String[] strings = shops.get(j).getDate().substring(0, 10).split("-");
                String[] strings1 = shops.get(i).getDate().substring(0, 10).split("-");

                if (Integer.parseInt(strings[1]) > Integer.parseInt(strings1[1])
                || Integer.parseInt(strings[2]) > Integer.parseInt(strings1[2])) {
                    Shop minimalShop = shops.get(i);
                    for(int k = j; k < shops.size(); k++){
                        shopList.add(shops.get(k));
                    }

                    shopList.remove(minimalShop);
                    shops.removeAll(shopList);

                    shops.addAll(shopList);
                    shopList.removeAll(shopList);
                }
            }
        }

        //here we are making the histogram
        for(Shop shop : shops) {
          if(y.getLabel().startsWith("Complaints"))
              set.getData().addAll(new XYChart.Data(shop.getDate().substring(0,10), shop.getNumberOfComplaints()));
          else if(y.getLabel().startsWith("Profit"))
              set.getData().addAll(new XYChart.Data(shop.getDate().substring(0,10), shop.getProfit()));
          else if(y.getLabel().startsWith("Order"))
               set.getData().addAll(new XYChart.Data(shop.getDate().substring(0,10), shop.getNumberOfOrders()));

        }

        Profit.getData().addAll(set);

    }

}