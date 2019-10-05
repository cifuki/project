public class test37 {
@Override
    public boolean onSearchRequested() {
        Intent intent = getIntent();
        String action = intent == null ? null : intent.getAction();
        if (action != null) {
            String word = null;
            if (action.equals(Intent.ACTION_SEARCH)) {
                word = intent.getStringExtra("query");
            } else if (action.equals(Intent.ACTION_SEND)) {
                word = intent.getStringExtra(Intent.EXTRA_TEXT);
            }
            if (word != null) {
                Intent next = new Intent();
                next.setClass(this, LookupActivity.class);
                next.setAction(Intent.ACTION_SEARCH);
                next.putExtra(SearchManager.QUERY, word);
                startActivity(next);
            }
        }
        finish();
        return true;
    }

}