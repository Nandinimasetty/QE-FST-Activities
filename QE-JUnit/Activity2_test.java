import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2_test {

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);

        assertDoesNotThrow(() -> account.withdraw(100));
    }

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(10);

        assertThrows(NotEnoughFundsException.class,
                () -> account.withdraw(100));
    }
}
