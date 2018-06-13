package io.block16.blockinfoj.ratelimit;

import lombok.Data;

@Data
public class RateLimitDTO {
    private Boolean banned;
    private Long timestamp;
    private Integer requestCount;
}
