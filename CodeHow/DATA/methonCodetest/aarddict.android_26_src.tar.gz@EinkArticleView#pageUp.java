public class test125 {
public boolean pageUp(boolean top) {
        int cury = articleView.getScrollY();
        if (cury == 0) { return false; }
        int newy = cury - HSCROLL_SIZE;
        if (newy < 0) {
            newy = 0;
        }
        articleView.realScrollTo(0, newy);

        partial = true;
        return true;
    }

}