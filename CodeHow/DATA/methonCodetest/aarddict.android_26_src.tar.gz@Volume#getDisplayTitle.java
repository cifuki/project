public class test223 {
public CharSequence getDisplayTitle(boolean withVolumeNumber) {
        String title;
        if (this.metadata.title == null) {
            title = this.origFile.getName();
        }
        else {
            title = this.metadata.title;
        }
        StringBuilder s = new StringBuilder(title);
        if (this.metadata.lang != null) {
            s.append(String.format(" (%s)", this.metadata.lang));
        }
        else {
            if (this.metadata.sitelang != null) {
                s.append(String.format(" (%s)", this.metadata.sitelang));
            }
            else {
                if (this.metadata.index_language != null && this.metadata.article_language != null) {
                    s.append(String.format(" (%s-%s)", this.metadata.index_language, this.metadata.article_language));
                }
            }
        }
        if (this.header.of > 1 && withVolumeNumber)
               s.append(String.format(" Vol. %s", this.header.volume));
        return s.toString();
    }

}