public class test14 {
@Override
        public void scrollTo(int x, int y) {
            //On Android 4.1 and 4.2 WebViewClassic.setNewPicture()
            //ultimately calls scrollTo(0, 0). This happens
            //after page load is finished and after ArticleViewActivity restored
            //scroll position. Overriding scrollTo() to do nothing
            //reliably prevents this. However, this also prevents programmatic
            //scrolling from JavaScript, so now JavaScript must call armScroll()
            //before calling any scrolling methods
            if (!mustBeArmedToScroll || scrollToArmed) {
                super.scrollTo(x, y);
                scrollToArmed = false;
            }
        }

}