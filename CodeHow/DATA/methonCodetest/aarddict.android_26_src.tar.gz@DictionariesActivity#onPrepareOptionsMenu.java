public class test72 {
@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int selected = listView.getSelectedItemPosition();
        boolean validSelection = selected != ListView.INVALID_POSITION;
        menu.getItem(0).setEnabled(validSelection);
        menu.getItem(1).setEnabled(validSelection);
        menu.getItem(2).setEnabled(true);
        return true;
    }

}