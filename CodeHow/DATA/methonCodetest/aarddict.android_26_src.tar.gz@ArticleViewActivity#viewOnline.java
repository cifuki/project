public class test54 {
private void viewOnline() {
        if (this.backItems.size() > 0) {
            Article current = this.backItems.get(this.backItems.size() - 1).article;
            Volume d = dictionaryService.getVolume(current.volumeId);
            String url = d == null ? null : d.getArticleURL(current.title);
            if (url != null) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(browserIntent);
            }
        }
    }

}