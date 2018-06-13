package io.block16.blockinfoj.controller;

import io.block16.blockinfoj.domain.BlockStorage;
import io.block16.blockinfoj.dto.FullBlockDto;
import io.block16.blockinfoj.dto.ResponseBlockDTO;
import io.block16.blockinfoj.exceptions.BadRequestException;
import io.block16.blockinfoj.service.BlockStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final BlockStorageService blockStorageService;

    @Autowired
    public BlockController(final BlockStorageService blockStorageService) {
        this.blockStorageService = blockStorageService;
    }

    @RequestMapping(value = "/v1/block/{blockNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBlockDTO getBlock(@PathVariable Long blockNumber) {
        if(blockNumber == null) {
            throw new BadRequestException("Block number cannot be null");
        }
        BlockStorage blockStorage = blockStorageService.findByBlockNumber(blockNumber);
        return ResponseBlockDTO.fromFullBlockDto(blockStorage.getBlockInfo());
    }
}
