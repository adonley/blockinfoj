package io.block16.blockinfoj.dto;

import lombok.Data;

import java.util.List;

@Data
public class FullBlockDto {
    FetchedBlockDTO block;
    List<FetchedBlockDTO> unclesList;
    List<FetchedTxDTO> transactions;
    List<FetchedTxReceiptDTO> receipts;
}
