public class test150 {
public Article redirect(Article article) throws RedirectTooManyLevels,
            ArticleNotFound, IOException {
        Article result = redirect(article, 0);
        if (result != article) {
            result.redirectedFromTitle = article.title;
        }
        return result;
    }

}