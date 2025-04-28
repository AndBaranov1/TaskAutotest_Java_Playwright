package org.example.pages;

public class RequestQuotePage extends BasePage {

    private final String nameInput = "//*[(@id = \"q_name\")]";
    private final String emailInput = "//*[(@id = \"q_email\")]";
    private final String serviceInput = "//*[(@id = \"q_service\")]";
    private final String messageTextarea = "//*[(@id = \"q_message\")]";
    private final String sendButton = "//*[@id=\"quoteForm\"]/div/div[5]/button";

    public RequestQuotePage(com.microsoft.playwright.Page page) {
        super(page);
    }

    public void fillForm(String name, String email, String service, String message) {
        page.fill(nameInput, name);
        page.fill(emailInput, email);
        page.selectOption(serviceInput, service);
        page.fill(messageTextarea, message);
    }

    public void submitForm() {
        page.click(sendButton);
    }
}
