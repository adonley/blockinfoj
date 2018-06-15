package io.block16.blockinfoj.repository;

import io.block16.blockinfoj.domain.BlockStorage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockStorageRepository extends MongoRepository<BlockStorage, Long> {
    BlockStorage findByBlockNumber(Long blockNumber);
}
