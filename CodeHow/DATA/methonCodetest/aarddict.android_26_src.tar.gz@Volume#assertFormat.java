public class test212 {
private void assertFormat() throws FormatException, IOException {
        Log.d(TAG, "Checking signature...");
        if (!this.header.signature.equals("aard")) {
            throw new InvalidSignatureException();
        }
        Log.d(TAG, "Checking format version...");
        if (this.header.version != 1) {
            throw new InvalidFormatVersionException();
        }
        Log.d(TAG, "Checking offsets sanity...");
        long fileSize = file.length();
        if (header.articleOffset > fileSize ||
            header.index1Offset > fileSize ||
            header.index2Offset > fileSize) {
            throw new CorruptedFileException();
        }
        Log.d(TAG, "Checking metadata length sanity...");
        if (header.metaLength > (1 << 23) ) {
            throw new MetadataTooBigException();
        }
        Log.d(TAG, "Sanity check ok");
    }

}