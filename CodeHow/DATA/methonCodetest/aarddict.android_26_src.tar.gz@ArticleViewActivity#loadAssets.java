public class test21 {
private void loadAssets() {
        try {
            this.sharedCSS = wrapCSS(readFile("shared.css"));
            this.mediawikiSharedCSS = wrapCSS(readFile("mediawiki_shared.css"));
            this.mediawikiMonobookCSS = wrapCSS(readFile("mediawiki_monobook.css"));
            this.js = wrapJS(readFile("aar.js"));
        } catch (IOException e) {
            Log.e(TAG, "Failed to load assets", e);
        }
    }

}