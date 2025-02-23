package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a list of transactions, find the highest transaction amount for each
 * customer using Streams. Output: Highest transaction per customer: Alice ->
 * 500 Bob -> 300 Charlie -> 100
 */
public class HighestTransactionAmount {
	public static void main(String[] args) {
		List<Transaction> transactions = List.of(new Transaction("Alice", 200), new Transaction("Bob", 150),
				new Transaction("Alice", 500), new Transaction("Bob", 300), new Transaction("Charlie", 100));
		   Map<String, Double> maxTransactions = transactions.stream()
		            .collect(Collectors.toMap(
		                Transaction::getCustomer,      // Key: Customer Name
		                Transaction::getAmount,        // Value: Transaction Amount
		                Double::max                    // Merge function to keep the max amount
		            ));
		   
	       System.out.println("Highest transaction per customer:");
	       maxTransactions.forEach((customer, amount) ->
	            System.out.println(customer + " -> " + amount)
	       );
	}
}

class Transaction {
	String customer;
	double amount;

	public Transaction(String customer, double amount) {
		this.customer = customer;
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public double getAmount() {
		return amount;
	}
}
