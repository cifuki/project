public class test138 {
static int calcSize(String structSpec) {
        int size = 0;
        int length = structSpec.length();
        //ignore byte order spec at index 0
        for (int i = 1; i < length; i++) {
            char c = structSpec.charAt(i);
            Integer unitSize = structSizes.get(c);
            if (unitSize != null) {
                size += unitSize;
            }
        }
        return size;
    }

}