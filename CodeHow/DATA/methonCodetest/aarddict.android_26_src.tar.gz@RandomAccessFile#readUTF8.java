public class test194 {
public final String readUTF8(int length) throws IOException {
        byte[] s = new byte[length];
        this.read(s);
        return Volume.utf8(s);
    }

}