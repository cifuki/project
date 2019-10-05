public class test2 {
@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;
        if (pointer != other.pointer)
            return false;
        if (section == null) {
            if (other.section != null)
                return false;
        } else if (!section.equals(other.section))
            return false;
        if (volumeId == null) {
            if (other.volumeId != null)
                return false;
        } else if (!volumeId.equals(other.volumeId))
            return false;
        return true;
    }

}