public class test153 {
private void launchWord(Entry theWord) {
        Intent next = new Intent();
        next.setClass(this, ArticleViewActivity.class);
        next.putExtra("word", theWord.title);
        next.putExtra("section", theWord.section);
        next.putExtra("volumeId", theWord.volumeId);
        next.putExtra("articlePointer", theWord.articlePointer);
        startActivity(next);
    }

}