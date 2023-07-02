package com.yunusakin.shortenurl.controller.requests;

public class ShortenUrlRequest {
    private String originalUrl;

    public ShortenUrlRequest() {
    }

    public ShortenUrlRequest(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
