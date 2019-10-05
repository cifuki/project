public class test232 {
String readKey(long pointer) throws IOException {
        Header h = this.header;
        long pos = h.index2Offset + pointer;
        RandomAccessFile f = this.file;
        f.seek(pos);
        int keyLength = (int)f.readSpec(h.keyLengthSpec);
        return f.readUTF8(keyLength);
    }

}