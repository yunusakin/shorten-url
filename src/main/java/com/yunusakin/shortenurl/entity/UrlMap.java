package com.yunusakin.shortenurl.entity;

import javax.persistence.*;

@Entity
@Table(name = "URL_MAP")
public class UrlMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHORT_URL")
    private String shortUrl;

    @Column(name = "ORIGINAL_URL")
    private String originalUrl;

    public UrlMap() {
    }

    public UrlMap(String shortUrl, String originalUrl) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
