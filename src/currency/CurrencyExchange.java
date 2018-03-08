/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author root
 */
public class CurrencyExchange extends transaction.Transaction{
    
    public static String url = "http://apilayer.net/api/live?access_key=a921fa1d6ebd929f0a7f6e861cf9f73f";
   
    public static JsonObject readJsonFromUrl() throws IOException, JsonIOException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      
     
      
      String jsonText = rd.readLine();
        System.err.println(jsonText);
      JsonParser jsonParser = new JsonParser();
//      JsonObject json = new Gson().toJson(jsonText);
          JsonObject json = (JsonObject)jsonParser.parse(jsonText.toString());
      Gson gson = new Gson();
          String result = gson.toJson(json);
          System.out.println(result);
      
//          int x = (JsonElement)json.getAsJsonObject("quotes").getAsDouble("USDEGP");

        JsonElement jelement = new JsonParser().parse(result);
    JsonObject  jobject = jelement.getAsJsonObject();
    jobject = jobject.getAsJsonObject("quotes");
        JsonElement x = jobject.get("USDEGP");
        double z = x.getAsDouble();
        System.err.println(z*2);
//        System.out.println((x*2));
//    JsonArray jarray = jobject.getAsJsonArray("translations");
//    jobject = jarray.get(0).getAsJsonObject();
//    String res = jobject.get("translatedText").toString();
          
      return json;
    } finally {
      is.close();
    }
  }
    
    
    public static double performTo(double amount, String to) throws IOException{
        
        JsonObject json = readJsonFromUrl();
        
         Gson gson = new Gson();
          String result = gson.toJson(json);
//          System.out.println(result);
      
//          int x = (JsonElement)json.getAsJsonObject("quotes").getAsDouble("USDEGP");

        JsonElement jelement = new JsonParser().parse(result);
        JsonObject  jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("quotes");
        JsonElement x = jobject.get("USD"+to);
        double z = x.getAsDouble();
        System.err.println(z);
        
        
        return amount*z;
    }
    
    
    public static double performFrom(double amount, String from) throws IOException{
        
        JsonObject json = readJsonFromUrl();
        
         Gson gson = new Gson();
          String result = gson.toJson(json);
//          System.out.println(result);
      
//          int x = (JsonElement)json.getAsJsonObject("quotes").getAsDouble("USDEGP");

        JsonElement jelement = new JsonParser().parse(result);
        JsonObject  jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("quotes");
        JsonElement x = jobject.get("USD"+from);
        double z = x.getAsDouble();
        System.err.println(z);
        
        
        return (amount/z);
    }

    @Override
    public boolean doTrans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
