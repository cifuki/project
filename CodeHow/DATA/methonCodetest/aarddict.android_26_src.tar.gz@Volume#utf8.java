public class test236 {
static String utf8(byte[] signature) {
        try {
            return new String(signature, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}