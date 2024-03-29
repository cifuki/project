public class test4 {
@SuppressWarnings("rawtypes")
    static Article fromJsonStr(String serializedArticle) throws IOException {
        Object[] articleTuple = Volume.mapper.readValue(serializedArticle, Object[].class);
        Article article = new Article();
        article.text = String.valueOf(articleTuple[0]);
        if (articleTuple.length == 3) {
                Map metadata = (Map)articleTuple[2];
            if (metadata.containsKey("r")) {
                article.redirect = String.valueOf(metadata.get("r"));
            }
            else if (metadata.containsKey("redirect")) {
                article.redirect = String.valueOf(metadata.get("redirect"));
            }
        }
        return article;
    }

}