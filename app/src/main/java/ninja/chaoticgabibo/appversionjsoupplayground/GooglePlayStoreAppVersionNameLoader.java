package ninja.chaoticgabibo.appversionjsoupplayground;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;

public class GooglePlayStoreAppVersionNameLoader extends AsyncTask<String, Void, String> {

    String newVersion;

    protected String doInBackground(String... urls) {
        try {
            return
                    Jsoup.connect("https://play.google.com/store/apps/details?id=" + "com.directed.android.smartstart" + "&hl=en")
                            .timeout(10000)
                            .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                            .referrer("http://www.google.com")
                            .get()
                            .select("div[itemprop=softwareVersion]")
                            .first()
                            .ownText();

        } catch (Exception e) {
            return "";
        }
    }

    protected void onPostExecute(String string) {
        newVersion = string;
        Log.d("new Version", newVersion);
    }
}