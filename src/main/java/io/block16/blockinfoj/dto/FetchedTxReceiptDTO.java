package io.block16.blockinfoj.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FetchedTxReceiptDTO {
    private String transactionHash;
    private String transactionIndex;
    private String blockHash;
    private String blockNumber;
    private String cumulativeGasUsed;
    private String gasUsed;
    private String contractAddress;
    private String root;
    // status is only present on Byzantium transactions onwards
    // see EIP 658 https://github.com/ethereum/EIPs/pull/658
    private String status;
    private String from;
    private String to;
    private List<LogDTO> logs;
    private String logsBloom;
}
