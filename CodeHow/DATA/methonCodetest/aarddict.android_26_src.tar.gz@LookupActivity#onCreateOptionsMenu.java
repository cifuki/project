public class test154 {
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_DICT_INFO, 0, R.string.mnInfo).setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(0, MENU_ABOUT, 0, R.string.mnAbout).setIcon(R.drawable.ic_menu_aarddict);
        return true;
    }

}