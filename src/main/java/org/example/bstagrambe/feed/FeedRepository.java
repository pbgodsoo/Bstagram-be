package org.example.bstagrambe.feed;

import org.example.bstagrambe.feed.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
