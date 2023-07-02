package com.yunusakin.shortenurl.repository;

import com.yunusakin.shortenurl.entity.UrlMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMap, Long> {
    UrlMap findByShortUrl(String shortUrl);
    UrlMap findByOriginalUrl(String original);
}
