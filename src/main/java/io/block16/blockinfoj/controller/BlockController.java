package io.block16.blockinfoj.controller;

import io.block16.blockinfoj.domain.BlockStorage;
import io.block16.blockinfoj.dto.FullBlockDto;
import io.block16.blockinfoj.service.BlockStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
public class BlockController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final BlockStorageService blockStorageService;


    @Autowired
    public BlockController(BlockStorageService blockStorageService) {
        this.blockStorageService = blockStorageService;
    }


    @RequestMapping(value = "/block/{blockNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FullBlockDto getBlock(@PathVariable Long blockNumber) throws ServletException {
        if(blockNumber == null) {
            LOGGER.info("Block number was null in request");
            throw new ServletException("Block number cannot be null");
        }

        BlockStorage blockStorage = blockStorageService.findByBlockNumber(blockNumber);
        return blockStorage.getBlockInfo();

/*
        FullBlockDto fullBlockDto = new FullBlockDto();
        fullBlockDto.setReceipts(blockStorage.getBlockInfo().getReceipts());
        fullBlockDto.setUnclesList(blockStorage.getBlockInfo().getUnclesList());
        fullBlockDto.setTransactions(blockStorage.getBlockInfo().getTransactions());

        return fullBlockDto;
*/
    }

}
