package surana.sidhanth.com.guvitask;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import surana.sidhanth.com.guvitask.model.item;

/**
 * Created by sidhanth on 22/9/16.
 */

public class ParseJson {


    public ArrayList<item> parseJson(String json)
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
