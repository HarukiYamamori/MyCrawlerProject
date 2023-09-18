package org.crawler;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.model.SubString;

import java.util.ArrayList;
import java.util.List;

public class CrawlDetailPage {
    public static void crawlDetailsPage(Page page) {
        List<String> detailsPageUrls = crawlDetailUrls(page);

        for(String detailsPageUrl : detailsPageUrls) {
            page.navigate(detailsPageUrl);
            String html = page.content();
            String fileName = detailsPageUrl;
            fileName = SubString.getSubString(fileName, "catalogue/", "/index");

            SaveFiles.saveFiles(html, fileName);
        }
    }

    public static List<String> crawlDetailUrls(Page page) {
        List<String> detailUrls = new ArrayList<>();
        List<ElementHandle> detailEls = page.querySelectorAll(".col-sm-8.col-md-9 .row > li");
        for(ElementHandle detailEl : detailEls) {
            ElementHandle detailUrl = detailEl.querySelector("h3 > a");
            String url = detailUrl.getAttribute("href");
            url = "https://books.toscrape.com/catalogue/" + url;
            detailUrls.add(url);
        }
        return detailUrls;
    }
}
