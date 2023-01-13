package es.ulpgc.dacd.apiScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scraper {
    private ArrayList<Hotel> hotelsList;

    public Scraper(){
        hotelsList = new ArrayList<>();
        String url = "https://www.booking.com/searchresults.es.html?sid=1c54fe47c864ff28f788bc14a7b9f120&checkout_month=&is_ski_area=0&ssne_untouched=Gran+Canaria&region=754&sb_lp=1&src=region&from_sf=1&ssne=Gran+Canaria&dest_type=city&group_children=0&no_rooms=1&group_adults=2&checkin_year=&dest_id=-388528&label=gen173nr-1FCAEoggI46AdIM1gEaEaIAQGYAQq4ARfIAQzYAQHoAQH4AQuIAgGoAgO4Apio8J0GwAIB0gIkM2RjODgwMTUtNWZjYy00NTlmLWIzMGQtNzQ5MmZkZTE2NWQw2AIG4AIB&checkin_month=&error_url=https%3A%2F%2Fwww.booking.com%2Fregion%2Fes%2Fgran-canaria.es.html%3Flabel%3Dgen173nr-1FCAEoggI46AdIM1gEaEaIAQGYAQq4ARfIAQzYAQHoAQH4AQuIAgGoAgO4Apio8J0GwAIB0gIkM2RjODgwMTUtNWZjYy00NTlmLWIzMGQtNzQ5MmZkZTE2NWQw2AIG4AIB%26sid%3D1c54fe47c864ff28f788bc14a7b9f120%26&b_h4u_keep_filters=&checkout_year=&ss=Gran+Canaria";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements hotel = doc.getElementsByClass("a4225678b2"); //a1b3f50dcd b2fe1a41c3 a7c67ebfe5 d19ba76520 d14b211b4f

            for (Element h : hotel) {
                String link = h.getElementsByTag("a").attr("href");
                
                Document doc2 = Jsoup.connect(link).get();
                String name = doc2.select("h2.d2fee87262.pp-header__title").text();
                String location = doc2.select("span.hp_address_subtitle.js-hp_address_subtitle.jq_tooltip").text();
                String services = doc2.select("div.bui-title__text.hotel-facilities-group__title-text").text();
                String ratings = doc2.select("div.ee746850b6.b8eef6afe1").text();
                String comments = doc2.select("div.db29ecfbe2.c688f151a2").text();

                hotelsList.add(new Hotel(name, location, services, ratings, comments, link));
                System.out.println(name + "\n" + location + "\n" + services + "\n" + ratings + "\n" + comments + "\n" + link + "\n\n");

            }

        }catch (IOException e){
            System.out.println(e);
        }
    }


    public ArrayList<Hotel> searchAll(){
        return hotelsList;
    }

    public Hotel search(String name){
        for (Hotel h: hotelsList){
            if (h.getName().equals(name)){
                return h;
            }
        }
        return null;
    }

}
