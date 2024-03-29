public class test97 {
private DeleteObserver getDeleteObserver(File file) {
            File parent = file.getParentFile();
            String dir = parent.getAbsolutePath();
            DeleteObserver observer = deleteObservers.get(dir);
            if (observer == null) {
                observer = new DeleteObserver(dir);
                observer.startWatching();
                deleteObservers.put(dir, observer);
            }
            return observer;
        }

}