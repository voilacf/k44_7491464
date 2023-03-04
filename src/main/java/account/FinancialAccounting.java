package account;

import java.util.ArrayList;
import java.util.HashMap;

public class FinancialAccounting {
    private final static HashMap<String, IAccount> accounts = new HashMap<>();
    private final static ArrayList<ChangeReceipt> receipts = new ArrayList<>();

    public static void addAccount(IAccount account) {
        accounts.put(account.getName(), account);
    }

    public static IAccount getAccount(String name) {
        return accounts.get(name);
    }

    public static void addReceipt(ChangeReceipt receipt) {
        receipts.add(receipt);
    }

    public static ArrayList<ChangeReceipt> getReceipts() {
        return receipts;
    }
}
