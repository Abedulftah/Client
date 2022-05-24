package Controller;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Shop;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class CompareHist {

    @FXML // fx:id="hist"
    private BarChart<?, ?> hist; // Value injected by FXMLLoader

    @FXML // fx:id="histX"
    private CategoryAxis histX; // Value injected by FXMLLoader

    @FXML // fx:id="histY"
    private NumberAxis histY; // Value injected by FXMLLoader
    public void initialize() {
        //we need to change the name of the column and the title according to the wanted histogram
        String[] stringA = msgObject.getMsg().split(" ");


        histY.setLabel(stringA[1]);
        hist.setTitle(stringA[1]);

        List<Shop> shops = (List<Shop>) msgObject.getObject();
        List<Shop> shopList = new ArrayList<>();


        XYChart.Series set = new XYChart.Series<>();
        XYChart.Series set1 = new XYChart.Series<>();

        set.setName("shop " + stringA[stringA.length-2]);
        set1.setName("shop " + stringA[stringA.length-1]);

        for(int j = 0; j < shops.size(); j++) {//bubble sort according to date
            for (int i = j + 1; i < shops.size(); i++) {
                String[] strings = shops.get(j).getDate().split("-");
                String[] strings1 = shops.get(i).getDate().split("-");

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
        shopList.removeAll(shopList);

        for(Shop shop : shops){
            if(shop.getShopId().equals(set.getName()))
                shopList.add(shop);
        }

        shops.removeAll(shopList);

        for(Shop shop : shopList) {
            if (histY.getLabel().startsWith("Complaints"))
                set.getData().addAll(new XYChart.Data(shop.getDate(), shop.getNumberOfComplaints()));
            else if (histY.getLabel().startsWith("Profit"))
                set.getData().addAll(new XYChart.Data(shop.getDate(), shop.getProfit()));
            else if (histY.getLabel().startsWith("Order"))
                set.getData().addAll(new XYChart.Data(shop.getDate(), shop.getNumberOfOrders()));
        }


        //description for a problem when set = 1 and set1 = 4 the histogram is not sorted
        //here we are making the histogram
        for(Shop shop : shops) {
            if(histY.getLabel().startsWith("Complaints")) {
                set1.getData().addAll(new XYChart.Data(shop.getDate(), shop.getNumberOfComplaints()));
            }
            else if(histY.getLabel().startsWith("Profit")) {
                set1.getData().addAll(new XYChart.Data(shop.getDate(), shop.getProfit()));
            }
            else if(histY.getLabel().startsWith("Order")) {
                set1.getData().addAll(new XYChart.Data(shop.getDate(), shop.getNumberOfOrders()));
            }
        }
//        boolean found = false;
//        for(Shop shop : shops){
//            found = false;
//            for(Shop shop1 : shopList){
//                if(shop.getDate().equals(shop1.getDate())) {
//                    found = true;
//                    break;
//                }
//            }
//            if(!found)
//                set1.getData().add(new XYChart.Data(shop.getDate(), 0));
//        }
//
//        for(Shop shop : shopList){
//            found = false;
//            for(Shop shop1 : shops){
//                if(shop.getDate().equals(shop1.getDate())) {
//                    found = true;
//                    break;
//                }
//            }
//            if(!found)
//                set.getData().add(new XYChart.Data(shop.getDate(), 0));
//        }

        //we need to find a solution how to add them the problem is here
        hist.getData().addAll(set, set1);
    }
}
