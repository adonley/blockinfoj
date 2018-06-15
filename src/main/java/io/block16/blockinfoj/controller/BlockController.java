package io.block16.blockinfoj.controller;

import io.block16.blockinfoj.domain.BlockStorage;
import io.block16.blockinfoj.dto.FullBlockDto;
import io.block16.blockinfoj.dto.ResponseBlockDTO;
import io.block16.blockinfoj.exceptions.BadRequestException;
import io.block16.blockinfoj.exceptions.NotFoundException;
import io.block16.blockinfoj.service.BlockStorageService;
import io.swagger.util.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.util.Arrays;

@RestController
public class BlockController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final BlockStorageService blockStorageService;
    private final boolean isProd;

    @Autowired
    public BlockController(
            final BlockStorageService blockStorageService,
            final Environment environment
    ) {
        this.blockStorageService = blockStorageService;
        this.isProd = Arrays.stream(environment.getActiveProfiles()).anyMatch(env -> (env.equalsIgnoreCase("prod")));
    }

    @RequestMapping(value = "/v1/block/{blockNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBlockDTO getBlock(@PathVariable Long blockNumber) {
        if(blockNumber == null) {
            throw new BadRequestException("Block number cannot be null");
        }
        BlockStorage blockStorage = blockStorageService.findByBlockNumber(blockNumber);
        if(blockStorage == null) {
            throw new NotFoundException("Could not find block " + blockNumber);
        }
        return ResponseBlockDTO.fromFullBlockDto(blockStorage.getBlockInfo());
    }
}
