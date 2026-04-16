package com.docshare;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.docshare.blockchain.ContractManager;
import com.docshare.transfer.NearbyTransferManager;
import com.docshare.wallet.WalletManager;

/**
 * MainActivity.java
 * Entry point — wires together wallet, contract, and transfer modules.
 */
public class MainActivity extends AppCompatActivity implements NearbyTransferManager.TransferCallback {

    private WalletManager walletManager;
    private ContractManager contractManager;
    private NearbyTransferManager transferManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: init wallet (load or create)
        // TODO: init contractManager with credentials
        // TODO: init transferManager
    }

    // ── NearbyTransferManager.TransferCallback ──

    @Override
    public void onDeviceFound(String endpointId, String endpointName) {
        // TODO: show device in UI, let user tap to connect
    }

    @Override
    public void onConnected(String endpointId) {
        // TODO: update UI — ready to send
    }

    @Override
    public void onTransferComplete(String endpointId, byte[] fileBytes) {
        // TODO: hash received file, verify against on-chain hash
    }

    @Override
    public void onError(String message) {
        // TODO: show error to user
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (transferManager != null) transferManager.stopAll();
        if (contractManager != null) contractManager.disconnect();
    }
}
