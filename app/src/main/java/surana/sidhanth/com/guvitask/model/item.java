package surana.sidhanth.com.guvitask.model;

/**
 * Created by sidhanth on 22/9/16.
 */

public class item {

    String name;
    int price;
    String description;
    String url;

    public void setName(String s)
    {
        this.name = s;
    }
    public void setPrice(int s)
    {
        this.price = s;
    }
    public void setDescription(String description2)
    {
        this.description = description2;
    }
    public void setUrl(String s)
    {
        this.url = s;
    }
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
    public String getDescription()
    {
        return description;
    }
    public String getUrl()
    {
        return url;
    }
}
