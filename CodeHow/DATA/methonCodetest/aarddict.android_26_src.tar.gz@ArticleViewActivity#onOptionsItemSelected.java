public class test32 {
@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_VIEW_ONLINE:
            viewOnline();
            break;
        case android.R.id.home:
        case MENU_NEW_LOOKUP:
            onSearchRequested();
            break;
        case MENU_ZOOM_IN:
            zoomIn();
            break;
        case MENU_ZOOM_OUT:
            zoomOut();
            break;
        case MENU_NEXT:
            nextArticle();
            break;
        case MENU_FIND_IN_PAGE:
            showFindDialog();
            break;
        default:
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

}