public class test132 {
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + (int) (articlePointer ^ (articlePointer >>> 32));
        result = prime * result + ((section == null) ? 0 : section.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result
                + ((volumeId == null) ? 0 : volumeId.hashCode());
        return result;
    }

}