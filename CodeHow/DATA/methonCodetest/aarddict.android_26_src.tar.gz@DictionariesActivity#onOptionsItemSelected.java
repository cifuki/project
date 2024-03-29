public class test71 {
@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selected = listView.getSelectedItemPosition();
        boolean validSelection = selected != ListView.INVALID_POSITION;
        switch (item.getItemId()) {
        case MENU_INFO:
            if (validSelection) {
                dataAdapter.showDetail(selected);
            }
            break;
        case MENU_VERIFY:
            if (validSelection) {
                dataAdapter.verify(selected);
            }
            break;
        case MENU_REFRESH:
            scandSDCard();
            break;
        }
        return true;
    }

}