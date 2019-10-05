public class test55 {
private String wrap(String articleText) {
        StringBuilder sb = new StringBuilder("<html>").append("<head>");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            sb.append("<meta name='viewport' content='width=device-width, initial-scale=1.0, user-scalable=0'/>");
        }
        return sb.append(this.sharedCSS).append(this.mediawikiSharedCSS)
                .append(this.mediawikiMonobookCSS).append(this.js)
                .append("</head>").append("<body>")
                .append("<div id=\"globalWrapper\">").append(articleText)
                .append("</div>").append("</body>").append("</html>")
                .toString();
    }

}