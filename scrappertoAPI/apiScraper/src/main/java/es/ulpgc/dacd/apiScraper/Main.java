package es.ulpgc.dacd.apiScraper;

import com.google.gson.Gson;

import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    public static Scraper scrap = new Scraper();

    public static void main(String[] args) {
        Gson gson = new Gson();

        after((request, response) -> {
            response.type("application/json");
        });

        notFound((request, response) -> {
            response.status(404);
            return gson.toJson("El recurso al que trata de acceder no existe");
        });

        get("/hotels", (request, response) -> {
            response.status(200);
            ArrayList hotels = scrap.searchAll();
            return hotels;
        }, gson::toJson);

        get("/hotels/:name", (request, response) -> {
            Hotel hotel = scrap.search(request.params(":name"));
            if (hotel != null){
                response.status(200);
                return hotel;
            }else{
                response.status(404);
                return ("Hotel no encontrado");
            }
        }, gson::toJson);


        get("/hotels/:name/location", (request, response) -> {
            Hotel hotel = scrap.search(request.params(":name"));
            if (hotel != null){
                response.status(200);
                return hotel;
            }else{
                response.status(404);
                return ("Hotel no encontrado");
            }
        }, gson::toJson);

        get("/hotels/:name/services", (request, response) -> {
            Hotel hotel = scrap.search(request.params(":name"));
            if (hotel != null){
                response.status(200);
                return hotel;
            }else{
                response.status(404);
                return ("Hotel no encontrado");
            }
        }, gson::toJson);

        get("/hotels/:name/ratings", (request, response) -> {
            Hotel hotel = scrap.search(request.params(":name"));
            if (hotel != null){
                response.status(200);
                return hotel;
            }else{
                response.status(404);
                return ("Hotel no encontrado");
            }
        }, gson::toJson);

        get("/hotels/:name/comments", (request, response) -> {
            Hotel hotel = scrap.search(request.params(":name"));
            if (hotel != null){
                response.status(200);
                return hotel;
            }else{
                response.status(404);
                return ("Hotel no encontrado");
            }
        }, gson::toJson);

    }
}