package es.ulpgc.dacd.apiScraper;

public class Hotel {
    private String name;
    private String location;
    private String services;
    private String ratings;
    private String comments;
    private String link;

    public Hotel(String name, String location, String services, String ratings, String comments, String link) {
        this.name = name;
        this.location = location;
        this.services = services;
        this.ratings = ratings;
        this.comments = comments;
        this.link = link;
    }

    public String getName() {
        return name;
    }
    public void setName(String title){
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getServices() {
        return services;
    }
    public void setServices(String services){
        this.services = services;
    }

    public String getRatings() {
        return ratings;
    }
    public void setRatings(String ratings){
        this.ratings = ratings;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link){
        this.link = link;
    }

}
