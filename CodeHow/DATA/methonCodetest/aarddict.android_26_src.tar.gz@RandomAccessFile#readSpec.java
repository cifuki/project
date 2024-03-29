public class test191 {
public final long readSpec(char spec) throws IOException {
        if (spec == 'L' || spec == 'I') {
            return readUnsignedInt();
        }
        if (spec == 'Q') {
            return readUnsignedLong();
        }
        if (spec == 'H') {
            return readUnsignedShort();
        }
        if (spec == 'l' || spec == 'i') {
            return readInt();
        }
        if (spec == 'q') {
            return readLong();
        }
        if (spec == 'h') {
            return this.readShort();
        }
        throw new IOException("Unsupported spec character " + spec);
    }

}