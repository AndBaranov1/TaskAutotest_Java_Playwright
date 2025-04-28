package tests;

import com.microsoft.playwright.Locator;
import org.example.pages.RequestQuotePage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequestQuoteTest extends TestBase {

    @Test(description = "Проверка успешной отправки формы запроса")
    public void testRequestQuoteForm() {
        page.navigate("https://qatest.datasub.com/index.html");

        page.click("text=Quote");
        RequestQuotePage quotePage = new RequestQuotePage(page);

        quotePage.fillForm("John Doe", "john@example.com", "Service 2", "Please contact me asap.");
        quotePage.submitForm();

        Locator statusMessage = page.locator("//*[(@id = \"quoteStatus\")]");

        statusMessage.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        assertTrue(statusMessage.isVisible(), "Статус отправки формы должен быть виден");
        assertThat(statusMessage).containsText("Форма отправлена успешно");
    }

    @Test(description = "Проверка не успешной отправки формы запроса")
    public void testRequestQuoteFormNotValid() {
        page.navigate("https://qatest.datasub.com/index.html");

        page.click("text=Quote");
        RequestQuotePage quotePage = new RequestQuotePage(page);
        quotePage.submitForm();
        Locator inputField = page.locator("//*[(@id = \"q_name\")]");
        inputField.waitFor();

        // Проверяем, что класс is-invalid присутствует
        String classAttribute = inputField.getAttribute("class");
        assertTrue(classAttribute.contains("is-invalid"), "Поле должно иметь класс is-invalid");
    }
}
