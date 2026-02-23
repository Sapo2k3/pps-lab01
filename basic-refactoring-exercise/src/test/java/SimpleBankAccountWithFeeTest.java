import example.model.AccountHolder;
import example.model.SimpleBankAccount;
import example.model.SimpleBankAccountWithFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithFeeTest  {

    private static final double INITIAL_BALANCE = 100;
    private static final int EXAMPLE_WITHDRAW = 30;
    private static final double FEE = 1;


    private AccountHolder accountHolder;
    private SimpleBankAccountWithFee bankAccount;
    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithFee(accountHolder,  INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final double balance = bankAccount.getBalance();
        bankAccount.withdraw(accountHolder.id(), EXAMPLE_WITHDRAW);
        assertEquals(balance - EXAMPLE_WITHDRAW - FEE, bankAccount.getBalance());
    }
}
