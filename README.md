# BlockShare — Blockchain Document Sharing for Android

AirDrop-style document sharing for Android with blockchain-based authenticity verification.

## How it works

1. Sender selects a document → SHA-256 hash generated locally
2. Smart contract logs `(docHash, senderAddress, receiverAddress)` on Ganache
3. File transferred peer-to-peer via Google Nearby Connections API (Wi-Fi Direct)
4. Receiver re-hashes the file and verifies it matches the on-chain record

## Stack

| Layer | Tech |
|---|---|
| Android app | Java, Android SDK |
| P2P transfer | Google Nearby Connections API |
| Blockchain client | Web3j |
| Smart contract | Solidity 0.8.x |
| Local blockchain | Ganache |

## Project structure

```
blockchain-doc-share/
├── contract/
│   ├── DocumentRegistry.sol       # Core smart contract
│   └── migrations/                # Truffle deploy scripts
└── android/app/src/main/java/com/docshare/
    ├── MainActivity.java
    ├── wallet/WalletManager.java   # Web3j keypair management
    ├── blockchain/ContractManager.java  # Contract interactions
    ├── transfer/NearbyTransferManager.java  # P2P file transfer
    └── utils/HashUtils.java        # SHA-256 hashing
```

## Setup

### Ganache
1. Install Ganache desktop or CLI
2. Start on port 7545
3. Update `GANACHE_URL` in `ContractManager.java` with your machine's local IP

### Smart contract
```bash
cd contract
npm install -g truffle
truffle migrate --network development
```
Copy the deployed contract address into `CONTRACT_ADDRESS` in `ContractManager.java`.

### Android
1. Open `android/` in Android Studio
2. Add dependencies to `build.gradle` (Web3j, Nearby Connections)
3. Build and run on two devices on the same Wi-Fi network

## Status

- [ ] Smart contract — `DocumentRegistry.sol`
- [ ] Wallet management
- [ ] Contract interaction via Web3j
- [ ] Nearby Connections file transfer
- [ ] UI
- [ ] End-to-end integration
