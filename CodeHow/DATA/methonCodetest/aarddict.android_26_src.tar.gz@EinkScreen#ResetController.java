public class test127 {
public static void ResetController(View view) {
        if (UpdateMode == cmodeClear) { return; }
        System.err.println("+++Soft reset Controller ");
        SetMode(view, cmodeClear);
        RefreshNumber = -1;
    }

}