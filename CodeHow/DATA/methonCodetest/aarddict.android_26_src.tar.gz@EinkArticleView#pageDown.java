public class test124 {
public boolean pageDown(boolean bottom) {
        int cury = articleView.getScrollY();
        int hmax = 0;
        if (HSCROLL_SIZE < articleView.getContentHeight() )
            hmax = (int) (articleView.getContentHeight() * articleView.getScale()) - HSCROLL_SIZE;
        if (cury == hmax) { return false; }
        int newy = cury + HSCROLL_SIZE;
        if (newy > hmax) {
            newy = hmax;
        }
        if (cury != newy) {
            articleView.realScrollTo(0, newy);
        }

        partial = true;
        return true;
    }

}