public class test38 {
private String readFile(String name) throws IOException {
        final char[] buffer = new char[0x1000];
        StringBuilder out = new StringBuilder();
        InputStream is = getResources().getAssets().open(name);
        Reader in = new InputStreamReader(is, "UTF-8");
        int read;
        do {
            read = in.read(buffer, 0, buffer.length);
            if (read > 0) {
                out.append(buffer, 0, read);
            }
        } while (read >= 0);
        return out.toString();
    }

}