public class test220 {
public String getArticleURL(String title) {
        String template = getArticleURLTemplate();
        if (template != null) {
                return template.replace("$1", Uri.encode(title));
        }
        return null;
    }

}