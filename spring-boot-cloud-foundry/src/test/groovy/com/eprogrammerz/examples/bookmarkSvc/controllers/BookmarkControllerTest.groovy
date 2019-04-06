package com.eprogrammerz.examples.bookmarkSvc.controllers

import com.eprogrammerz.examples.bookmarkSvc.repositories.BookmarkRepository
import spock.lang.Specification

class BookmarkControllerTest extends Specification {

    BookmarkController bookmarkController

    BookmarkRepository bookmarkRepository

    void setup() {
        bookmarkRepository = Mock()
        bookmarkController = new BookmarkController(bookmarkRepository)
    }

    def "Get bookmarks with userId" () {
        given:
        def userId = "yogen"
        def bookmarks = []
        bookmarkRepository.findByUserId(userId) >> bookmarks

        when:
        def response = bookmarkController.getBookmarks(userId)

        then:
        response == []

        1 * bookmarkRepository.findByUserId(userId) >> bookmarks
        0 * _
    }
}
