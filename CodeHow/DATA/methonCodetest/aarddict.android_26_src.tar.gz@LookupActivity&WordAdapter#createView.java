public class test164 {
private TwoLineListItem createView(ViewGroup parent) {
                TwoLineListItem item;
                if (DeviceInfo.EINK_SCREEN)
                        item = (TwoLineListItem) mInflater.inflate(
                        R.layout.eink_simple_list_item_2, parent, false);
                else
                item = (TwoLineListItem) mInflater.inflate(
                        android.R.layout.simple_list_item_2, parent, false);
            item.getText2().setSingleLine();
            item.getText2().setEllipsize(TextUtils.TruncateAt.END);
            return item;
        }

}