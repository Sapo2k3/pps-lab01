import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int DEPOSIT_EXAMPLE = 100;
    private static final int WRONG_DEPOSIT_EXAMPLE = 50;
    private static final int NEGATIVE_AMOUNT = -100;
    private static final int WITHDRAW_EXAMPLE = 70;
    private static final int NEGATIVE_WITHDRAW = -50;
    private static final int WRONG_ID = 2;
    private static final int INITIAL_AMOUNT = 0;

    protected AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testNegativeInitialBalance() {
        AccountHolder accountHolder = new AccountHolder("Pietro", "Neri", 2);
        assertThrows(IllegalArgumentException.class, () -> new SimpleBankAccount(accountHolder, NEGATIVE_AMOUNT));
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_EXAMPLE);
        assertEquals(DEPOSIT_EXAMPLE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_EXAMPLE);
        bankAccount.deposit(WRONG_ID, WRONG_DEPOSIT_EXAMPLE);
        assertEquals(DEPOSIT_EXAMPLE, bankAccount.getBalance());
    }

    @Test
    void testNegativeDepositAmount() {
        bankAccount.deposit(accountHolder.id(), NEGATIVE_AMOUNT);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_EXAMPLE);
        final double balance = bankAccount.getBalance();
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_EXAMPLE);
        assertEquals(balance - WITHDRAW_EXAMPLE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_EXAMPLE);
        bankAccount.withdraw(WRONG_ID,  WITHDRAW_EXAMPLE);
        assertEquals(DEPOSIT_EXAMPLE, bankAccount.getBalance());
    }

    @Test
    void testNegativeWithdrawtAmount() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_EXAMPLE);
        bankAccount.withdraw(accountHolder.id(), NEGATIVE_WITHDRAW);
        assertEquals(DEPOSIT_EXAMPLE, bankAccount.getBalance());
    }


}
