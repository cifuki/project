public class test5 {
public String getRedirect() {
        if (this.redirect != null && this.section != null) {
            return this.redirect + "#" + this.section;
        }
        return this.redirect;
    }

}