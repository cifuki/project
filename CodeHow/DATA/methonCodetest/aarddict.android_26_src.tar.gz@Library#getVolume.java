public class test148 {
public Volume getVolume(String volumeId) {

        for (Volume d : this) {
            if (d.sha1sum.equals(volumeId)) {
                return d;
            }
        }
        return null;
    }

}