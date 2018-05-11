package in.mynewcar.notificationpage.models;

public class Notification {
    String heading;
    String subheading;
    String imageURL;
    String date;
    String content;

    public Notification(String heading, String subheading, String imageURL, String date, String content){
        this.heading = heading;
        this.subheading = subheading;
        this.imageURL = imageURL;
        this.date = date;
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

}
