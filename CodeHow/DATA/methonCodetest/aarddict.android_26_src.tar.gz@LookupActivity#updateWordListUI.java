public class test162 {
private void updateWordListUI(final Iterator<Entry> results) {
        runOnUiThread(new Runnable() {
            public void run() {
                TextView messageView = (TextView)findViewById(R.id.messageView);
                if (!results.hasNext()) {
                    Editable text = editText.getText();
                    if (text != null && !text.toString().equals("")) {
                        messageView.setText(Html.fromHtml(getString(R.string.nothingFound)));
                        messageView.setVisibility(View.VISIBLE);
                    }
                    else {
                        messageView.setVisibility(View.GONE);
                    }
                }
                else {
                        messageView.setVisibility(View.GONE);
                }
                WordAdapter wordAdapter = new WordAdapter(results);
                listView.setAdapter(wordAdapter);
                listView.setOnItemClickListener(wordAdapter);
                setProgressBarIndeterminateVisibility(false);
            }
        });
    }

}