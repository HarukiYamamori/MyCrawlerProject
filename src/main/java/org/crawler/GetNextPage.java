package org.crawler;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class GetNextPage {
    public static List<String> getNextPage(Page page) {
        List<String> nextPageUrls = new ArrayList<>();
        while(checkNextPageExist(page)) {
            ElementHandle nextPageEl = page.querySelector(".pager .next > a");
            String nextPageUrl = nextPageEl.getAttribute("href");
            String strToIgnore = "catalogue/";
            if(nextPageUrl.contains(strToIgnore)) {
                nextPageUrl = nextPageUrl.replaceAll(strToIgnore, "");
            }
            nextPageUrl = "https://books.toscrape.com/catalogue/" + nextPageUrl;
            nextPageUrls.add(nextPageUrl);
            page.navigate(nextPageUrl);
        }
        return nextPageUrls;
    }

    public static int pageCount(int totalPage, int countInOnePage) {
        int pageCount = totalPage / countInOnePage;
        return pageCount;
    }

    public static boolean checkNextPageExist(Page page) {
        ElementHandle nextPageCheckTag = page.querySelector(".pager .next > a");
        boolean isElementPresent = nextPageCheckTag != null;
        return isElementPresent;
    }
}
