package maps_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RoadsApi {

    private static String URL = "https://roads.googleapis.com/v1/nearestRoads?points=%s&key=%s";
    private static String APIKEY = "AIzaSyDOXFVIhlU_vXNSM_4GFuNBigk_XMTFOdo";

    /*public List<SnappedPoint> CoordinatesToPlaceIds(List<TransLocationDto> transLocations) throws IOException {
        String locations = transLocationsToString(transLocations);
        String fullUrl = String.format(URL, locations, APIKEY);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(fullUrl);
        HttpResponse response = httpClient.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return null;
    }

    private String transLocationsToString(List<TransLocationDto> transLocations) {
        StringBuilder sb = new StringBuilder();
        for (TransLocationDto tl : transLocations) {
            sb.append(tl.getLat());
            sb.append(",");
            sb.append(tl.getLon());
            sb.append("|");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }*/
}
