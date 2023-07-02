package com.yunusakin.shortenurl.controller.responses;

public class ShortenUrlResponse {
    private String shortenUrl;


    public ShortenUrlResponse() {
    }

    public ShortenUrlResponse(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }
}
