class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

class TransactionProcessor {
    public void processTransaction(String transactionId, double amount) throws TransactionException {
        try {
            if (amount <= 0) {
                throw new TransactionException("Invalid transaction amount: " + amount);
            }
            System.out.println("Transaction " + transactionId + " processed successfully for $" + amount);
        } catch (TransactionException e) {
            throw new TransactionException("Error processing transaction [" + transactionId + "]: " + e.getMessage());
        }
    }
}

public class TransactionApp {
    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();

        try {
            processor.processTransaction("TXN123", -500);
        } catch (TransactionException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }
}
