package org.example.bstagrambe.feed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class FeedDto {
    @Getter
    @NoArgsConstructor
    public static class RegReq {
        private String contents;

        public Feed toEntity() {
            return Feed.builder()
                    .contents(this.contents)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String contents;

        public static RegRes from(Feed entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .build();
        }
    }
}
