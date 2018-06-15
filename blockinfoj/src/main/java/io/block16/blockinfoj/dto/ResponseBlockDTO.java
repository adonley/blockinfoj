package io.block16.blockinfoj.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBlockDTO {
    private String number;
    private String hash;
    private String parentHash;
    private String nonce;
    private String sha3Uncles;
    private String logsBloom;
    private String transactionsRoot;
    private String stateRoot;
    private String receiptsRoot;
    private String author;
    private String miner;
    private String mixHash;
    private String difficulty;
    private String totalDifficulty;
    private String extraData;
    private String size;
    private String gasLimit;
    private String gasUsed;
    private String timestamp;

    List<FetchedBlockDTO> unclesList;
    List<FetchedTxDTO> transactions;
    List<FetchedTxReceiptDTO> receipts;

    public static ResponseBlockDTO fromFullBlockDto(FullBlockDto fullBlockDto) {
        ResponseBlockDTO rb = new ResponseBlockDTO();

        // Block transformation
        rb.setNumber(fullBlockDto.getBlock().getNumber());
        rb.setHash(fullBlockDto.getBlock().getHash());
        rb.setParentHash(fullBlockDto.getBlock().getParentHash());
        rb.setNonce(fullBlockDto.getBlock().getNonce());
        rb.setSha3Uncles(fullBlockDto.getBlock().getSha3Uncles());
        rb.setLogsBloom(fullBlockDto.getBlock().getLogsBloom());
        rb.setTransactionsRoot(fullBlockDto.getBlock().getTransactionsRoot());
        rb.setStateRoot(fullBlockDto.getBlock().getStateRoot());
        rb.setReceiptsRoot(fullBlockDto.getBlock().getReceiptsRoot());
        rb.setAuthor(fullBlockDto.getBlock().getAuthor());
        rb.setMiner(fullBlockDto.getBlock().getMiner());
        rb.setMixHash(fullBlockDto.getBlock().getMixHash());
        rb.setDifficulty(fullBlockDto.getBlock().getDifficulty());
        rb.setTotalDifficulty(fullBlockDto.getBlock().getTotalDifficulty());
        rb.setExtraData(fullBlockDto.getBlock().getExtraData());
        rb.setSize(fullBlockDto.getBlock().getSize());
        rb.setGasLimit(fullBlockDto.getBlock().getGasLimit());
        rb.setGasUsed(fullBlockDto.getBlock().getGasUsed());
        rb.setTimestamp(fullBlockDto.getBlock().getTimestamp());

        // Blockinfo transformation
        rb.unclesList = fullBlockDto.getUnclesList();
        rb.transactions = fullBlockDto.getTransactions();
        rb.receipts = fullBlockDto.getReceipts();
        return rb;
    }
}
