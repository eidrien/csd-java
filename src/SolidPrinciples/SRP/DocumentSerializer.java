package SolidPrinciples.SRP;

import com.google.gson.Gson;

/**
 * Created by Alberto on 13/10/15.
 */
public class DocumentSerializer
{
    public String Serialize(SolidPrinciples.SRP.Document document) {
        Gson gsonParser= new Gson();
        return gsonParser.toJson(document);
    }
}
