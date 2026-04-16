// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

/**
 * DocumentRegistry.sol
 * Handles sender/receiver verification and document hash logging.
 * Deploy on Ganache (http://192.168.x.x:7545)
 */
contract DocumentRegistry {

    struct DocumentTransfer {
        address sender;
        address receiver;
        bytes32 docHash;
        bytes32 prevTransferHash;
        uint256 timestamp;
        bool verified;
    }

    // transferId => DocumentTransfer
    mapping(bytes32 => DocumentTransfer) public transfers;

    // Events
    event TransferInitiated(bytes32 indexed transferId, address indexed sender, address indexed receiver, bytes32 docHash);
    event TransferVerified(bytes32 indexed transferId);

    /**
     * Sender initiates transfer — logs hash + receiver address on chain
     */
    function initiateTransfer(
        address _receiver,
        bytes32 _docHash,
        bytes32 _prevTransferHash
    ) public returns (bytes32 transferId) {
        // TODO: implement
    }

    /**
     * Receiver confirms they got the document — marks transfer verified
     */
    function confirmReceived(bytes32 _transferId) public {
        // TODO: implement
    }

    /**
     * Verify a document hash matches what was logged
     */
    function verifyDocument(bytes32 _transferId, bytes32 _docHash) public view returns (bool) {
        // TODO: implement
    }

    /**
     * Get transfer details
     */
    function getTransfer(bytes32 _transferId) public view returns (DocumentTransfer memory) {
        return transfers[_transferId];
    }
}
