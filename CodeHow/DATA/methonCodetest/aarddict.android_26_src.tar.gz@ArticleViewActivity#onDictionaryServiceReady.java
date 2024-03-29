public class test28 {
@Override
    void onDictionaryServiceReady() {
        if (this.backItems.isEmpty()) {
            final Intent intent = getIntent();
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                String _word = null;
                if (action.equals(Intent.ACTION_SEARCH)) {
                    _word = intent.getStringExtra("query");
                } else if (action.equals(Intent.ACTION_SEND)) {
                    _word = intent.getStringExtra(Intent.EXTRA_TEXT);
                }

                final String word = _word;

                if (word != null) {

                    if (currentTask != null) {
                        currentTask.cancel();
                    }

                    currentTask = new TimerTask() {
                        @Override
                        public void run() {
                            setProgress(500);
                            String currentWord = word;
                            Log.d(TAG,
                                    "intent.getDataString(): "
                                            + intent.getDataString());
                            while (currentWord.length() > 0) {
                                Iterator<Entry> results = dictionaryService
                                        .lookup(currentWord);
                                Log.d(TAG, "Looked up " + word);
                                if (results.hasNext()) {
                                    currentTask = null;
                                    Entry entry = results.next();
                                    showArticle(entry);
                                    break;
                                } else {
                                    currentWord = currentWord.substring(0,
                                            currentWord.length() - 1);
                                }
                            }
                            if (currentWord.length() == 0) {
                                onSearchRequested();
                            }
                        }
                    };

                    try {
                        timer.schedule(currentTask, 0);
                    } catch (Exception e) {
                        Log.d(TAG, "Failed to schedule task", e);
                        showError(getString(R.string.msgErrorLoadingArticle,
                                word));
                    }
                }
            } else {
                String word = intent.getStringExtra("word");
                String section = intent.getStringExtra("section");
                String volumeId = intent.getStringExtra("volumeId");
                long articlePointer = intent.getLongExtra("articlePointer", -1);
                dictionaryService.setPreferred(volumeId);
                showArticle(volumeId, articlePointer, word, section);
            }
        } else {
            showCurrentArticle();
        }
    }

}