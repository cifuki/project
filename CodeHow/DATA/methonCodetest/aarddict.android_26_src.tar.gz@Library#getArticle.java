public class test147 {
public Article getArticle(Entry e) throws IOException {
        Volume d = getVolume(e.volumeId);
        Article a = d.readArticle(e.articlePointer);
        a.title = e.title;
        a.section = e.section;
        return a;
    }

}