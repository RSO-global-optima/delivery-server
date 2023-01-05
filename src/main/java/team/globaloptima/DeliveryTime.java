package team.globaloptima;

import java.util.*;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeliveryTime {

    private OkHttpClient client;

    public double[] getAddressLatLon(String address) {
        String parameters = "&city=Ljubljana&postalcode=1000&accept-language=en&polygon_threshold=0.0";

        OkHttpClient client = new OkHttpClient();

        address = address.replaceAll(",", "%2C");

        Request request = new Request.Builder()
                .url("https://forward-reverse-geocoding.p.rapidapi.com/v1/forward?street=" + address + parameters)
                .get()
                .addHeader("X-RapidAPI-Key", "7ec20c098emshe16b98bd0d1f04cp1d97f8jsn3f0f050d99f7")
                .addHeader("X-RapidAPI-Host", "forward-reverse-geocoding.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            JsonParser parser = new JsonParser();
            JsonArray json = parser.parse(responseBody).getAsJsonArray();

            JsonObject location = json.get(0).getAsJsonObject();
            double lat = location.get("lat").getAsDouble();
            double lon = location.get("lon").getAsDouble();

            return new double[] {lat, lon};
        } catch (IOException e) {
            // Handle the exception here
            // You can print the error message, log it, or throw a different exception
            System.err.println("An error occurred while trying to get the latitude and longitude: " + e.getMessage());
            return null;
        }
    }

    public Integer getEstimateDistance(double[] start, double[] finish) {

        OkHttpClient client = new OkHttpClient();

        String origin = start[0] + "%2C" + start[1];
        String destin = finish[0] + "%2C" + finish[1];

        System.out.println(origin + destin);

        Request request = new Request.Builder()
                .url("https://trueway-matrix.p.rapidapi.com/CalculateDrivingMatrix?origins=" + origin + "&destinations=" + destin)
                .get()
                .addHeader("X-RapidAPI-Key", "7ec20c098emshe16b98bd0d1f04cp1d97f8jsn3f0f050d99f7")
                .addHeader("X-RapidAPI-Host", "trueway-matrix.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            System.out.println(responseBody);

            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(responseBody).getAsJsonObject();

            Integer duration = json.get("durations").getAsJsonArray().get(0)
                                                    .getAsJsonArray().get(0).getAsInt();

            return duration;
        } catch (IOException e) {
            // Handle the exception here
            // You can print the error message, log it, or throw a different exception
            System.err.println("An error occurred while trying to get the latitude and longitude: " + e.getMessage());
            return null;
        }

    }

}
