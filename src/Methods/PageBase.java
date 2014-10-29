package Methods;

import data.DataStorage;
import data.Settings;
import org.testng.Assert;

import java.util.Properties;

public abstract class PageBase extends Settings {

    private static String PAGE_URL;


    protected PageBase() {
        // Init Properties
        try {
            initProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //PageFactory.initElements(Settings.getDriver(), this);
        String currentUrl = Settings.getDriver().getCurrentUrl();
        String path = currentUrl.replace(getBaseUrl(), "");
        Assert.assertTrue(isCorrectPath(path, getPageUrls()));
        this.PAGE_URL = path;
        Init();
    }

    protected abstract void Init();

    // Returns true if at least one url from <ClassName>+_URLS list corresponds current url
    private Boolean isCorrectPath(String path, String[] locations) {
        Boolean result = false;
        for (int i = 0; i <= locations.length - 1; i++) {
            if (locations[i].equals(path)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // This method gets Properties for the Page from DataStorage and creates new Properties named <ClassName>+"_URLS".
    // Then it puts those Properties into DataStorage. So it looks like (<ClassName>+"_URLS">, Properties pageUrls).
    // Returns an String array with all possible URL values for current page

    private final String[] getPageUrls() {
        if (!DataStorage.getInstance().exists(getClass().getSimpleName() + "_URLS")) {
            Object[] PAGE_URLS = DataStorage.getInstance().getProperty(getClass().getSimpleName()).stringPropertyNames().toArray();
            String[] pageUrls = new String[PAGE_URLS.length];
            Properties urlProperties = new Properties();
            int j = 0;
            for (int i = 0; i <= PAGE_URLS.length - 1; i++) {
                if (PAGE_URLS[i].toString().contains("url.")) {
                    pageUrls[j] = getProperty(PAGE_URLS[i].toString());
                    urlProperties.setProperty(PAGE_URLS[i].toString(), pageUrls[j]);
                    j++;
                }
            }
            DataStorage.getInstance().setProperty(getClass().getSimpleName() + "_URLS", urlProperties);
            return pageUrls;
        } else {
            Properties PageUrls = DataStorage.getInstance().getProperty(getClass().getSimpleName() + "_URLS");
            Object[] PAGE_URLS = DataStorage.getInstance().getProperty(getClass().getSimpleName() + "_URLS").stringPropertyNames().toArray();
            String[] pageUrls = new String[PAGE_URLS.length];
            for (int i = 0; i <= PageUrls.size() - 1; i++) {
                pageUrls[i] = PageUrls.getProperty(PAGE_URLS[i].toString());
            }
            PAGE_URLS = PageUrls.keySet().toArray();
            return pageUrls;
        }
    }

    // Check if current Page consists of text
    public boolean pageContains(String text) {
        if (getDriver().getPageSource().contains(text)) {
            return true;
        } else {
            return false;
        }
    }


}

