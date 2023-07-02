package com.yunusakin.shortenurl.controller;

import com.yunusakin.shortenurl.controller.requests.ShortenUrlRequest;
import com.yunusakin.shortenurl.controller.responses.ShortenUrlResponse;
import com.yunusakin.shortenurl.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<Object> shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        return ResponseEntity.ok(new ShortenUrlResponse(urlService.shortenUrl(shortenUrlRequest.getOriginalUrl())));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirectUrl(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header("Location", originalUrl).build();
    }
}

