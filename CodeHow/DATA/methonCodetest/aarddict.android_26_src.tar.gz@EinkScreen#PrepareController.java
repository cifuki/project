public class test126 {
public static void PrepareController(View view, boolean isPartially) {
        if (isPartially || IsSleep != isPartially) {
            SleepController(isPartially, view);
            //                              if (isPartially)
            return;
        }
        if (RefreshNumber == -1) {
            switch (UpdateMode) {
            case cmodeClear:
                SetMode(view, cmodeClear);
                break;
            case cmodeActive:
                if (UpdateModeInterval == 0) {
                    SetMode(view, cmodeActive);
                }
                break;
            }
            RefreshNumber = 0;
            return;
        }
        if (UpdateMode == cmodeClear) {
            SetMode(view, cmodeClear);
            return;
        }
        if (UpdateMode > 0 && (UpdateModeInterval > 0 || UpdateMode == 1)) {
            if (RefreshNumber == 0 || (UpdateMode == cmodeOneshot && RefreshNumber < UpdateModeInterval)) {
                switch (UpdateMode) {
                case cmodeActive:
                    SetMode(view, cmodeActive);
                    break;
                case cmodeOneshot:
                    SetMode(view, cmodeOneshot);
                    break;
                }
            } else if (UpdateModeInterval <= RefreshNumber) {
                SetMode(view, cmodeClear);
                RefreshNumber = -1;
            }
            if (UpdateModeInterval > 0) {
                RefreshNumber++;
            }
        }

        return;
        /*
          if (UpdateMode == 1 && UpdateModeInterval != 0) {
          if (RefreshNumber == 0) {
          // ?	? 	�x�Q, ��Ȫ 	�� 
����"����
          N2EpdController.setMode(N2EpdController.REGION_APP_3,
          N2EpdController.WAVE_GL16,
          N2EpdController.MODE_ACTIVE, view); // why not MODE_ACTIVE_ALL?
          } else if (UpdateModeInterval == RefreshNumber) {
          // ���� ��?������ ����?"��Ȱ ?" ?	?? 	�x�Q?
          N2EpdController.setMode(N2EpdController.REGION_APP_3,
          N2EpdController.WAVE_GU,
          N2EpdController.MODE_CLEAR_ALL, view);
          RefreshNumber = -1;
          }
          RefreshNumber ++;
          }
        */
        //}
    }

abc  }
}