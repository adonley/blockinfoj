package io.block16.blockinfoj.service;


import io.block16.blockinfoj.domain.BlockStorage;
import io.block16.blockinfoj.repository.BlockStorageRepository;
import org.springframework.stereotype.Service;

@Service
public class BlockStorageService {

    private final BlockStorageRepository blockStorageRepository;

    public BlockStorageService(final BlockStorageRepository blockStorageRepository) {
        this.blockStorageRepository = blockStorageRepository;
    }

    public BlockStorage save(BlockStorage blockStorage) {
        return blockStorageRepository.save(blockStorage);
    }

    public BlockStorage findByBlockNumber(Long blockNumber) {
        return blockStorageRepository.findByBlockNumber(blockNumber);
    }

}
