package org.crawler;

import com.microsoft.playwright.*;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            String baseUrl = "https://books.toscrape.com/index.html";

            page.navigate(baseUrl);
            List<String> nextPageUrls = GetNextPage.getNextPage(page);
            CrawlDetailPage.crawlDetailsPage(page);


            for(String nextPageUrl : nextPageUrls) {
                page.navigate(nextPageUrl);
                CrawlDetailPage.crawlDetailsPage(page);
            }

            page.close();
        }
    }
}
