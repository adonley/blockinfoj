package io.block16.blockinfoj.domain;

import io.block16.blockinfoj.dto.FullBlockDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class BlockStorage {
    @Id
    private Long blockNumber;
    private FullBlockDto blockInfo;
}
