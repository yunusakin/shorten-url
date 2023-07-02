package com.yunusakin.shortenurl.service;

import com.yunusakin.shortenurl.entity.UrlMap;
import com.yunusakin.shortenurl.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlMappingRepository urlMappingRepository;

    public UrlService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String shortenUrl(String originalUrl) {
        UrlMap urlMap = urlMappingRepository.findByOriginalUrl(originalUrl);
        if (urlMap != null) {
            return urlMap.getShortUrl();
        } else {
            String shortUrl = generateShortUrl();
            urlMap = new UrlMap(shortUrl, originalUrl);
            urlMappingRepository.save(urlMap);
            return shortUrl;
        }
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMap urlMap = urlMappingRepository.findByShortUrl(shortUrl);
        return (urlMap != null) ? urlMap.getOriginalUrl() : null;
    }

    String generateShortUrl() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}

