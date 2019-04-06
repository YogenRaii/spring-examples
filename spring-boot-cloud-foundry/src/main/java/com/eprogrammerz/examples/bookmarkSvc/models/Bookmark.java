package com.eprogrammerz.examples.bookmarkSvc.models;

import com.eprogrammerz.examples.bookmarkSvc.models.types.BookmarkType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Yogen on 9/26/2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bookmark {
    private String userId;

    @Id
    @GeneratedValue
    private Long id;

    private String href;

    private String description;

    private String label;

    @ElementCollection(targetClass = BookmarkType.class)
    private List<BookmarkType> bookmarkTypes;

    public Bookmark(String userId, String href,
                    String description, String label) {
        this.userId = userId;
        this.href = href;
        this.description = description;
        this.label = label;
    }
}
