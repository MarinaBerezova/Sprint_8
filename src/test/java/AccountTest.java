import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @DisplayName("Check name - Max length")
    @Description("Check name cannot be greater than 19 symbols")
    @Test
    public void checkNameLengthGreaterThan19ReturnFalse() {
        Account account = new Account("Тимотей Шевролешевро");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Check name - Min length")
    @Description("Check name cannot be less than 3 symbols")
    @Test
    public void checkNameLengthLessThan3ReturnFalse() {
        Account account = new Account("ТШ");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Check name - No extra spaces 1")
    @Description("Check name cannot starts with space")
    @Test
    public void checkNameWithStartSpaceReturnFalse() {
        Account account1 = new Account(" ТимотиШаламе");
        Account account2 = new Account(" Тимоти Шаламе");
        assertFalse(account1.checkNameToEmboss());
        assertFalse(account2.checkNameToEmboss());
    }

    @DisplayName("Check name - No extra spaces 2")
    @Description("Check name cannot ends with space")
    @Test
    public void checkNameWithEndSpaceReturnFalse() {
        Account account1 = new Account("ТимотиШаламе ");
        Account account2 = new Account("Тимоти Шаламе ");
        assertFalse(account1.checkNameToEmboss());
        assertFalse(account2.checkNameToEmboss());
    }

    @DisplayName("Check name  - A space separator")
    @Description("Check name should has one space in the middle")
    @Test
    public void checkNameNoSpaceInTheMiddleReturnFalse() {
        Account account = new Account("ТимотиШаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Check name - No extra spaces 3")
    @Description("Check name cannot contains more than one space")
    @Test
    public void checkNameManySpacesInTheMiddleReturnFalse() {
        Account account = new Account("Тимо Ти Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Check name - Short name")
    @Description("Check name length can be 3 symbols")
    @Test
    public void checkNameLengthIs3ReturnTrue() {
        Account account = new Account("Т Ш");
        assertTrue(account.checkNameToEmboss());
    }

    @DisplayName("Check name - Long name")
    @Description("Check name length can be 19 symbols")
    @Test
    public void checkNameLengthIs19ReturnTrue() {
        Account account = new Account("Тимотей Шевролешевр");
        assertTrue(account.checkNameToEmboss());
    }

    @DisplayName("Check name")
    @Description("Check name - base test")
    @Test
    public void checkValidNameReturnTrue() {
        Account account1 = new Account("Ти Ш");
        Account account2 = new Account("Иван Иванов");
        Account account3 = new Account("Тимотей Шевролешев");
        assertTrue(account1.checkNameToEmboss());
        assertTrue(account2.checkNameToEmboss());
        assertTrue(account3.checkNameToEmboss());
    }
}
