public class test122 {
@Override
    protected void onDraw (Canvas canvas) {
        if (partial) EinkScreen.PrepareController(this, false); // partial refresh
        else EinkScreen.ResetController(1, this);

        super.onDraw(canvas);
        partial = false;
    }

}