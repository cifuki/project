public class test46 {
private void showCurrentArticle() {
        runOnUiThread(new Runnable() {
            public void run() {
                setProgress(5000);
                resetTitleToCurrent();
                Article a = backItems.get(backItems.size() - 1).article;
                Log.d(TAG, "Show article: " + a.text);
                articleView.loadDataWithBaseURL(BASE_URL, wrap(a.text), "text/html",
                        "utf-8", null);
            }
        });
    }

}