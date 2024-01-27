package com.voiture.voiture.modele;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// @JsonIgnoreProperties(ignoreUnknown = true)
public class ImgBBData {
    // private String url;
    private String id;
    private String title;
    @JsonProperty("url_viewer")
    private String urlViewer;
    private String url;
    @JsonProperty("display_url")
    private String displayUrl;
    private int width;
    private int height;
    private int size;
    private long time;
    private int expiration;
    private ImgBBImage image;
    private ImgBBThumb thumb;
    @JsonProperty("delete_url")
    private String deleteUrl;


    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlViewer() {
        return urlViewer;
    }

    public void setUrlViewer(String urlViewer) {
        this.urlViewer = urlViewer;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public ImgBBImage getImage() {
        return image;
    }

    public void setImage(ImgBBImage image) {
        this.image = image;
    }

    public ImgBBThumb getThumb() {
        return thumb;
    }

    public void setThumb(ImgBBThumb thumb) {
        this.thumb = thumb;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImgBBData(String url) {
        this.url = url;
    
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }
    
    
}
// "https://i.ibb.co/ysM48jY/5fa6e99c683e.png",
// "https://i.ibb.co/ysM48jY/5fa6e99c683e.png"