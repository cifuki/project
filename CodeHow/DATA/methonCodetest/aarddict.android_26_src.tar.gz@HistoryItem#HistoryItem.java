public class test142 {
HistoryItem(HistoryItem that) {
        this.entries = that.entries;
        this.entryIndex = that.entryIndex;
        if (that.article != null) {
            this.article = new Article(that.article);
        }
    }

}