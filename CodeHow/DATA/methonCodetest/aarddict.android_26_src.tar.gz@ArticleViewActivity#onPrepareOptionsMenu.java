public class test34 {
@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean enableViewOnline = false;
        boolean hasNextArticle = false;
        if (this.backItems.size() > 0) {
            HistoryItem historyItem = backItems.get(backItems.size() - 1);
            Article current = historyItem.article;
            Volume d = dictionaryService.getVolume(current.volumeId);
            enableViewOnline = d != null && d.getArticleURLTemplate() != null;
            hasNextArticle = historyItem.hasNext();
        }
        miViewOnline.setEnabled(enableViewOnline);
        miNextArticle.setVisible(hasNextArticle);
        return true;
    }

}