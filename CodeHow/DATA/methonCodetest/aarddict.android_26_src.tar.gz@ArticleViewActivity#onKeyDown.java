public class test29 {
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
            goBack();
            break;
        case NOOK_KEY_PREV_LEFT:
        case NOOK_KEY_PREV_RIGHT:
        case KeyEvent.KEYCODE_VOLUME_UP:
            if (!articleView.pageUp(false)) {
                goBack();
            }
            break;
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        case NOOK_KEY_NEXT_LEFT:
        case NOOK_KEY_NEXT_RIGHT:
            if (!articleView.pageDown(false)) {
                nextArticle();
            };
            break;
        default:
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

}