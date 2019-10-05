public class test230 {
Article readArticle(long pointer) throws IOException {
        Article a = articleCache.get(pointer);
        if (a != null)
                return a;
        Header h = this.header;
        long pos = h.articleOffset + pointer;
        RandomAccessFile f = this.file;
        f.seek(pos);
        long articleLength = f.readSpec(h.articleLengthSpec);

        byte[] articleBytes = new byte[(int) articleLength];
        f.read(articleBytes);
        String serializedArticle = decompress(articleBytes);
        a = Article.fromJsonStr(serializedArticle);
        a.dictionaryUUID = h.uuid;
        a.volumeId = h.sha1sum;
        a.pointer = pointer;
        articleCache.put(pointer, a);
        return a;
    }

}