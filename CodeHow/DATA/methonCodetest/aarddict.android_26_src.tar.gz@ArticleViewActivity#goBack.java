public class test18 {
private void goBack() {
        if (backItems.size() == 1) {
            finish();
        }
        if (currentTask != null) {
            return;
        }
        if (backItems.size() > 1) {
            HistoryItem current = backItems.remove(backItems.size() - 1);
            HistoryItem prev = backItems.get(backItems.size() - 1);

            Article prevArticle = prev.article;
            if (prevArticle.equalsIgnoreSection(current.article)) {
                resetTitleToCurrent();
                if (!prevArticle.sectionEquals(current.article)
                        && !restoreScrollPos()) {
                    goToSection(prevArticle.section);
                }
            } else {
                showCurrentArticle();
            }
        }
    }

}