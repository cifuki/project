public class test128 {
private static void SetMode(View view, int mode) {
        switch (mode) {
        case cmodeClear:
            N2EpdController.setMode(N2EpdController.REGION_APP_3,
                                    N2EpdController.WAVE_GC,
                                    N2EpdController.MODE_ONESHOT_ALL);
            //                              N2EpdController.MODE_CLEAR, view);
            break;
        case cmodeOneshot:
            N2EpdController.setMode(N2EpdController.REGION_APP_3,
                                    N2EpdController.WAVE_GU,
                                    N2EpdController.MODE_ONESHOT_ALL);
            //                      N2EpdController.MODE_ONESHOT_ALL, view);
            break;
        case cmodeActive:
            N2EpdController.setMode(N2EpdController.REGION_APP_3,
                                    N2EpdController.WAVE_GL16,
                                    N2EpdController.MODE_ACTIVE_ALL);
            //                      N2EpdController.MODE_ACTIVE_ALL, view);
            break;
        }
    }

}