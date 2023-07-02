package com.yunusakin.shortenurl.controller;

import com.yunusakin.shortenurl.controller.requests.ShortenUrlRequest;
import com.yunusakin.shortenurl.controller.responses.ShortenUrlResponse;
import com.yunusakin.shortenurl.service.UrlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UrlControllerTests {
    @Mock
    private UrlService urlService;

    @InjectMocks
    private UrlController urlController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShortenUrl() {
        // Arrange
        String originalUrl = "https://www.example.com";
        String shortUrl = "abc123";
        ShortenUrlRequest request = new ShortenUrlRequest(originalUrl);
        when(urlService.shortenUrl(originalUrl)).thenReturn(shortUrl);

        // Act
        ResponseEntity<Object> responseEntity = urlController.shortenUrl(request);
        ShortenUrlResponse response = (ShortenUrlResponse) responseEntity.getBody();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(response);
        assertEquals(shortUrl, response.getShortenUrl());


        verify(urlService, times(1)).shortenUrl(originalUrl);
    }

    @Test
    public void testRedirectUrl() {

        String shortUrl = "abc123";
        String originalUrl = "https://www.example.com";
        when(urlService.getOriginalUrl(shortUrl)).thenReturn(originalUrl);


        ResponseEntity<Object> responseEntity = urlController.redirectUrl(shortUrl);


        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(originalUrl, responseEntity.getHeaders().getFirst("Location"));

        verify(urlService, times(1)).getOriginalUrl(shortUrl);
    }

    @Test
    public void testRedirectUrlNotFound() {
        String shortUrl = "nonExistentShortUrl";
        when(urlService.getOriginalUrl(shortUrl)).thenReturn(null);


        ResponseEntity<Object> responseEntity = urlController.redirectUrl(shortUrl);


        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(urlService, times(1)).getOriginalUrl(shortUrl);
    }
}


