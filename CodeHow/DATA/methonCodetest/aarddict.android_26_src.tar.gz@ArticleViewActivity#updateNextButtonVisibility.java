public class test53 {
private void updateNextButtonVisibility() {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            return;
        }
        if (currentHideNextButtonTask != null) {
            currentHideNextButtonTask.cancel();
            currentHideNextButtonTask = null;
        }
        boolean hasNextArticle = false;
        if (backItems.size() > 0) {
            HistoryItem historyItem = backItems.get(backItems.size() - 1);
            hasNextArticle = historyItem.hasNext();
        }
        final Button nextButton = (Button) findViewById(R.id.NextButton);
        if (hasNextArticle) {
            if (nextButton.getVisibility() == View.GONE) {
                nextButton.setVisibility(View.VISIBLE);
            }
            currentHideNextButtonTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            if (useAnimation) {
                                nextButton.startAnimation(fadeOutAnimation);
                            } else {
                                nextButton.setVisibility(View.GONE);
                            }
                            currentHideNextButtonTask = null;
                        }
                    });
                }
            };
            try {
                timer.schedule(currentHideNextButtonTask, 1800);
            } catch (IllegalStateException e) {
                // this may happen if orientation changes while users touches
                // screen
                Log.d(TAG, "Failed to schedule \"Next\" button hide", e);
            }
        } else {
            nextButton.setVisibility(View.GONE);
        }
    }

}