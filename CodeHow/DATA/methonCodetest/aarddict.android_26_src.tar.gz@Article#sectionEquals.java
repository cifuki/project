public class test8 {
public boolean sectionEquals(Article other) {
        return (section == null && other.section == null) ||
            (section !=null && other.section != null && section.equals(other.section));
    }

}