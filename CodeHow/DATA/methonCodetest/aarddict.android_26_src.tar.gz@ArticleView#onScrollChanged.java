public class test12 {
@Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                super.onScrollChanged(l, t, oldl, oldt);
                if (scrollListener != null) {
                        scrollListener.onScroll(l, t, oldl, oldt);
                }
        }

}