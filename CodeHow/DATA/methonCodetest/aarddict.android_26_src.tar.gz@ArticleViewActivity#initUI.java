public class test20 {
@Override
    void initUI() {
        this.scrollPositionsH = Collections
                .synchronizedMap(new HashMap<Article, ScrollXY>());
        this.scrollPositionsV = Collections
                .synchronizedMap(new HashMap<Article, ScrollXY>());
        loadAssets();

        if (DeviceInfo.EINK_SCREEN) {
            useAnimation = false;
            setContentView(R.layout.eink_article_view);
            articleView = (ArticleView) findViewById(R.id.EinkArticleView);
            N2EpdController.n2MainActivity = this;
            EinkScreen.ResetController(2, articleView); // force full screen
                                                        // refresh when changing
                                                        // articles
        }
        // Setup animations only on non-eink screens
        else {
            useAnimation = true;
            fadeOutAnimation = new AlphaAnimation(1f, 0f);
            fadeOutAnimation.setDuration(600);
            fadeOutAnimation.setAnimationListener(new AnimationAdapter() {
                public void onAnimationEnd(Animation animation) {
                    Button nextButton = (Button) findViewById(R.id.NextButton);
                    nextButton.setVisibility(Button.GONE);
                }
            });

            getWindow().requestFeature(Window.FEATURE_PROGRESS);
            setContentView(R.layout.article_view);
            articleView = (ArticleView) findViewById(R.id.ArticleView);
        }

        timer = new Timer();

        backItems = Collections.synchronizedList(new LinkedList<HistoryItem>());

        if (android.os.Build.VERSION.SDK_INT >= 11) {
            try {
                showFindDialogMethod = articleView.getClass().getMethod(
                        "showFindDialog", String.class, boolean.class);
            } catch (NoSuchMethodException e1) {
                Log.d(TAG, "showFindDialog method not found");
            }

        }

        articleView.setOnScrollListener(new ArticleView.ScrollListener() {
            public void onScroll(int l, int t, int oldl, int oldt) {
                saveScrollPos(l, t);
            }
        });

        articleView.getSettings().setJavaScriptEnabled(true);
        articleView.addJavascriptInterface(new SectionMatcher(), "matcher");
        articleView.addJavascriptInterface(articleView, "scrollControl");

        articleView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                    JsResult result) {
                Log.d(TAG + ".js", String.format("[%s]: %s", url, message));
                result.cancel();
                return true;
            }

            public void onProgressChanged(WebView view, int newProgress) {
                Log.d(TAG, "Progress: " + newProgress);
                setProgress(5000 + newProgress * 50);
            }
        });

        articleView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "Page finished: " + url);
                currentTask = null;
                String section = null;

                if (url.contains("#")) {
                    LookupWord lookupWord = LookupWord.splitWord(url);
                    section = lookupWord.section;
                    if (backItems.size() > 0) {
                        HistoryItem currentHistoryItem = backItems
                                .get(backItems.size() - 1);
                        HistoryItem h = new HistoryItem(currentHistoryItem);
                        h.article.section = section;
                        backItems.add(h);
                    }
                } else if (backItems.size() > 0) {
                    Article current = backItems.get(backItems.size() - 1).article;
                    section = current.section;
                }
                if (!restoreScrollPos()) {
                    goToSection(section);
                }
                updateNextButtonVisibility();
                articleView.armScroll();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String origUrl) {
                Log.d(TAG, "URL clicked: " + origUrl);
                final String url;
                if (origUrl.startsWith(BASE_URL)) {
                    url = origUrl.substring(BASE_URL.length());
                    if (currentTask == null) {
                        currentTask = new TimerTask() {
                            public void run() {
                                try {
                                    Article currentArticle = backItems
                                            .get(backItems.size() - 1).article;
                                    try {
                                        Iterator<Entry> currentIterator = dictionaryService
                                                .followLink(url,
                                                        currentArticle.volumeId);
                                        List<Entry> result = new ArrayList<Entry>();
                                        while (currentIterator.hasNext()
                                                && result.size() < 20) {
                                            result.add(currentIterator.next());
                                        }
                                        showNext(new HistoryItem(result));
                                    } catch (ArticleNotFound e) {
                                        showMessage(getString(
                                                R.string.msgArticleNotFound,
                                                e.word.toString()));
                                    }
                                } catch (Exception e) {
                                    StringBuilder msgBuilder = new StringBuilder(
                                            "There was an error following link ")
                                            .append("\"").append(url)
                                            .append("\"");
                                    if (e.getMessage() != null) {
                                        msgBuilder.append(": ").append(
                                                e.getMessage());
                                    }
                                    final String msg = msgBuilder.toString();
                                    Log.e(TAG, msg, e);
                                    showError(msg);
                                }
                            }
                        };
                        try {
                            timer.schedule(currentTask, 0);
                        } catch (Exception e) {
                            Log.d(TAG, "Failed to schedule task", e);
                        }
                    }
                }
                else {
                    try {
                        Uri uri = Uri.parse(origUrl);
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(browserIntent);
                    }
                    catch (Exception e) {
                        Toast.makeText(ArticleViewActivity.this, String.format("Failed to parse URL %s", origUrl),
                                Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        final Button nextButton = (Button) findViewById(R.id.NextButton);
        nextButton.getBackground().setAlpha(180);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (nextButton.getVisibility() == View.VISIBLE) {
                    updateNextButtonVisibility();
                    nextArticle();
                    updateNextButtonVisibility();
                }
            }
        });
        articleView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                updateNextButtonVisibility();
                return false;
            }
        });

        setProgressBarVisibility(true);
    }

}