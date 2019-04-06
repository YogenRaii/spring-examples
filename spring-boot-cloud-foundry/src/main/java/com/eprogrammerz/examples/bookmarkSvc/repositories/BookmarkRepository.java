package com.eprogrammerz.examples.bookmarkSvc.repositories;

import com.eprogrammerz.examples.bookmarkSvc.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yogen on 9/26/2017.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUserId(String userId);
    Bookmark findByUserIdAndId(String userId, Long id);
}
