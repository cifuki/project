public class test67 {
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_INFO, 0, R.string.mnDictDetails).setIcon(
                android.R.drawable.ic_menu_info_details);
        menu.add(0, MENU_VERIFY, 1, R.string.mnDictVerify).setIcon(
                android.R.drawable.ic_menu_manage);
        menu.add(0, MENU_REFRESH, 2, R.string.mnDictRefresh).setIcon(
                R.drawable.ic_menu_refresh);
        return true;
    }

}