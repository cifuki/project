public class test92 {
@Override
        void initUI() {
        setContentView(R.layout.dict_info);
        tabs = (TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        setTitle(R.string.titleDictionaryInfoActivity);
        }

}