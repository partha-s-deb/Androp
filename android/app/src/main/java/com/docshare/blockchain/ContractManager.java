package com.docshare.blockchain;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * ContractManager.java
 * Handles Web3j connection to Ganache and smart contract interactions.
 */
public class ContractManager {

    private Web3j web3j;
    private Credentials credentials;

    // Update IP to your Ganache machine on local network
    private static final String GANACHE_URL = "http://192.168.x.x:7545";

    // Set after deploying contract on Ganache
    private static final String CONTRACT_ADDRESS = "";

    public ContractManager(Credentials credentials) {
        this.credentials = credentials;
        this.web3j = Web3j.build(new HttpService(GANACHE_URL));
    }

    /**
     * Initiate a document transfer on chain
     * @param receiverAddress receiver's wallet address
     * @param docHash SHA-256 hash of document as bytes32
     * @param prevTransferHash hash of previous transfer (bytes32 zero if first)
     * @return transferId
     */
    public String initiateTransfer(String receiverAddress, byte[] docHash, byte[] prevTransferHash) throws Exception {
        // TODO: call DocumentRegistry.initiateTransfer() via Web3j wrapper
        return null;
    }

    /**
     * Confirm document received on chain
     */
    public void confirmReceived(String transferId) throws Exception {
        // TODO: call DocumentRegistry.confirmReceived()
    }

    /**
     * Verify document hash matches on-chain record
     */
    public boolean verifyDocument(String transferId, byte[] docHash) throws Exception {
        // TODO: call DocumentRegistry.verifyDocument()
        return false;
    }

    public void disconnect() {
        if (web3j != null) web3j.shutdown();
    }
}
