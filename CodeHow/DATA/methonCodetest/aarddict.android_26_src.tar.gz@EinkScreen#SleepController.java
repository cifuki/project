public class test129 {
public static void SleepController(boolean toSleep, View view) {
        if (toSleep == IsSleep) {
            return;
        }
        System.err.println("+++SleepController " + toSleep);
        IsSleep = toSleep;
        if (IsSleep) {
            switch (UpdateMode) {
            case cmodeClear:
                break;
            case cmodeOneshot:
                break;
            case cmodeActive:
                SetMode(view, cmodeClear);
                RefreshNumber = -1;
            }
        } else {
            ResetController(UpdateMode, view);
        }
        return;
    }

}