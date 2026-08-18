package preparation.swissre.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuildTransaction {

	public static List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();

		transactions.add(new Transaction("Food", 100));
		transactions.add(new Transaction("Food", 200));
		transactions.add(new Transaction("Food", 150));

		transactions.add(new Transaction("Shopping", 100));
		transactions.add(new Transaction("Shopping", 150));
		transactions.add(new Transaction("Shopping", 200));

		transactions.add(new Transaction("Utilities", 100));
		transactions.add(new Transaction("Utilities", 150));
		transactions.add(new Transaction("Utilities", 200));

		transactions.add(new Transaction("Entertainment", 100));
		transactions.add(new Transaction("Entertainment", 150));
		transactions.add(new Transaction("Entertainment", 200));

		transactions.add(new Transaction("Travel", 100));
		transactions.add(new Transaction("Travel", 150));
		transactions.add(new Transaction("Travel", 200));
		return transactions;
	}

}
