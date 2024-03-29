public class test26 {
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (showFindDialogMethod != null) {
            MenuItem miFindInPage = menu.add(0, MENU_FIND_IN_PAGE, 0,
                    R.string.mnFindInPage).setIcon(
                    android.R.drawable.ic_menu_search);
            MenuItemCompat.setShowAsAction(miFindInPage,
                    MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        }
        miViewOnline = menu.add(0, MENU_VIEW_ONLINE, 0, R.string.mnViewOnline)
                .setIcon(android.R.drawable.ic_menu_view);
        menu.add(0, MENU_NEW_LOOKUP, 0, R.string.mnNewLookup).setIcon(
                android.R.drawable.ic_menu_search);
        menu.add(0, MENU_ZOOM_OUT, 0, R.string.mnZoomOut).setIcon(
                R.drawable.ic_menu_zoom_out);
        menu.add(0, MENU_ZOOM_IN, 0, R.string.mnZoomIn).setIcon(
                R.drawable.ic_menu_zoom_in);
        miNextArticle = menu.add(0, MENU_NEXT, 0, R.string.mnNext).setIcon(
                android.R.drawable.ic_media_next);
        MenuItemCompat.setShowAsAction(miNextArticle,
                MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

}