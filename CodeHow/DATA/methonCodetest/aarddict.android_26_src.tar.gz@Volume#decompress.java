public class test215 {
static String decompress(byte[] bytes) {
        String type = null;
        long t0 = System.currentTimeMillis();
        try {
            String result = decompressZlib(bytes);
            type = "zlib";
            return result;
        }
        catch (Exception e1) {
            try {
                String result = decompressBz2(bytes);
                type = "bz2";
                return result;
            }
            catch (IOException e2) {
                String result = utf8(bytes);
                type = "uncompressed";
                return result;
            }
        }
        finally {
                Log.d(TAG, "Decompressed " + type + " in " + (System.currentTimeMillis() - t0));
        }
    }

}