public class test93 {
@Override
        void onDictionaryServiceReady() {
                tabs.addTab(tabs.newTabSpec("d").setIndicator(getString(R.string.tabDescription)).setContent(this));
                tabs.addTab(tabs.newTabSpec("c").setIndicator(getString(R.string.tabCopyright)).setContent(this));
                tabs.addTab(tabs.newTabSpec("s").setIndicator(getString(R.string.tabSource)).setContent(this));
                tabs.addTab(tabs.newTabSpec("l").setIndicator(getString(R.string.tabLicense)).setContent(this));
        }

}