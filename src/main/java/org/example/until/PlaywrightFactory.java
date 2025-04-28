package org.example.until;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    public static Page initPage() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public static void close() {
        browser.close();
        playwright.close();
    }
}
