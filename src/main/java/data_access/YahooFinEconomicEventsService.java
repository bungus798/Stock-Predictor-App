package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class YahooFinEconomicEventsService {

    public static String getEconomicEvents(String ticker) {
        try {
            String authorization = "7aa0af6cf0mshc69956a71e31b89p19cb70jsn7137ce116466";
            OkHttpClient client = new OkHttpClient();
            String url = String.format("https://yahoo-finance15.p.rapidapi.com/api/v1/markets/stock/modules?ticker=%s&module=calendar-events", ticker);

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("X-RapidAPI-Key", authorization)
                    .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSECFilings(String ticker) {
        try {
            String authorization = "7aa0af6cf0mshc69956a71e31b89p19cb70jsn7137ce116466";
            OkHttpClient client = new OkHttpClient();
            String url = String.format("https://yahoo-finance15.p.rapidapi.com/api/v1/markets/stock/modules?ticker=%s&module=sec-filings", ticker);

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("X-RapidAPI-Key", authorization)
                    .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
