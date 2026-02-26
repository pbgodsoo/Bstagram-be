package org.example.bstagrambe.feed;

import lombok.RequiredArgsConstructor;
import org.example.bstagrambe.feed.model.Feed;
import org.example.bstagrambe.feed.model.FeedDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;

    public FeedDto.RegRes register(FeedDto.RegReq dto) {
        Feed entity = dto.toEntity();
        entity = feedRepository.save(entity);

        return FeedDto.RegRes.from(entity);
    }
}
