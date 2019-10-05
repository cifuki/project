public class test19 {
private void goToSection(String section) {
        Log.d(TAG, "Go to section " + section);
        if (section == null || section.trim().equals("")) {
            scrollTo(0, 0);
        } else {
            articleView.loadUrl(String.format(
                    "javascript:scrollToMatch(\"%s\")", section));
        }
    }

}