package surana.sidhanth.com.guvitask;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import surana.sidhanth.com.guvitask.model.item;

/**
 * Created by sidhanth on 22/9/16.
 */

public class ParseJson {

    String json = "[{\"_id\":\"57c928fb208e95cc2d30e779\",\"item_name\":\"Chicken" +
            "Coffee\",\"item_description\":\"Ada Chicken la " +
            "coffee\",\"item_type\":\"Coffee\",\"item_status\":2,\"toast_price\":250,\"restaurant\":\"572afada57f0798a07e1ee07\",\"__v\":0,\"active\":true,\"item_image_url_path\":[\"/home/toast2/toast/public/uploads/1472114407898Humus-&-Pita-.jpg\"],\"item_image_url\":[\"http://toastcentral.com/uploads/1472114407898Humus-&-Pita-.jpg\"]},{\"_id\":\"57c92abc6742c38402b51757\",\"item_name\":\"Chicken" +
            "Soup\",\"item_description\":\"Ada Chicken la " +
            "soup\",\"item_type\":\"Soup\",\"item_status\":2,\"toast_price\":250,\"restaurant\":\"572afada57f0798a07e1ee07\",\"__v\":0,\"active\":true,\"item_image_url_path\":[\"/home/toast2/toast/public/uploads/1472114407898Humus-&-Pita-.jpg\"],\"item_image_url\":[\"http://toastcentral.com/uploads/1472114407898Humus-&-Pita-.jpg\"]},{\"_id\":\"57c92af46742c39202b51756\",\"item_name\":\"Chicken" +
            "Rice\",\"item_description\":\"Ada Chicken la rice\",\"item_type\":\"Main\n" +
            "Dish\",\"item_status\":2,\"toast_price\":250,\"restaurant\":\"572afada57f0798a07e1ee07\",\"__v\":0,\"active\":true,\"item_image_url_path\":[\"/home/toast2/toast/public/uploads/1472114407898Humus-&-Pita-.jpg\"],\"item_image_url\":[\"http://toastcentral.com/uploads/1472114407898Humus-&-Pita-.jpg\"]},{\"_id\":\"57c92b116742c36c02b51756\",\"item_name\":\"Chicken" +
            "Curry \",\"item_description\":\"Ada Chicken la curry\",\"item_type\":\"Side\n" +
            "Dish\",\"item_status\":2,\"toast_price\":250,\"restaurant\":\"572afada57f0798a07e1ee07\",\"__v\":0,\"active\":true,\"item_image_url_path\":[\"/home/toast2/toast/public/uploads/1472114407898Humus-&-Pita-.jpg\"],\"item_image_url\":[\"http://toastcentral.com/uploads/1472114407898Humus-&-Pita-.jpg\"]}]";
    public ArrayList<item> parseJson()
    {
        ArrayList<item> items = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i =0 ;i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                item new_item = new item();
                new_item.setName(jsonObject.getString("item_name"));
                new_item.setPrice(jsonObject.getInt("toast_price"));
                new_item.setDescription(jsonObject.getString("item_description"));
                JSONArray jsonArray1 = jsonObject.getJSONArray("item_image_url");
                String url = jsonArray1.getString(0);
                new_item.setUrl(url);
                Log.e("url is",new_item.getUrl());
                Log.e("name is",new_item.getName());
                items.add(new_item);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return items;
    }
}
