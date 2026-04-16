package com.docshare.wallet;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;

/**
 * WalletManager.java
 * Handles Web3j wallet creation, loading, and signing.
 */
public class WalletManager {

    private Credentials credentials;
    private static final String WALLET_DIR = "wallets/";

    /**
     * Create a new wallet and save to file
     * @param password wallet encryption password
     * @param walletDir directory to store wallet file
     */
    public void createWallet(String password, File walletDir) throws Exception {
        // TODO: implement using WalletUtils.generateNewWalletFile()
    }

    /**
     * Load existing wallet from file
     */
    public void loadWallet(String password, File walletFile) throws Exception {
        // TODO: implement using WalletUtils.loadCredentials()
    }

    /**
     * Get loaded credentials (address + keys)
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Get wallet address as string
     */
    public String getAddress() {
        if (credentials == null) return null;
        return credentials.getAddress();
    }
}
