package io.block16.blockinfoj.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FetchedTxDTO {
    private String hash;
    private String nonce;
    private String blockHash;
    private String blockNumber;
    private String transactionIndex;
    private String from;
    private String to;
    private String value;
    private String gasPrice;
    private String gas;
    private String input;
    private String creates;
    private String publicKey;
    private String raw;
    private String r;
    private String s;
    private int v;  // see https://github.com/web3j/web3j/issues/44
}
