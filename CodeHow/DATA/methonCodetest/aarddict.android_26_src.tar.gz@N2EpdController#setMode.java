public class test186 {
public static void setMode(int region, int wave, int mode) {
        if (mtSetRegion != null) {
            try {
                if (DeviceInfo.EINK_NOOK_120 && mEpdController == null)
                    mEpdController = EpdControllerConstructors[0].newInstance(new Object[] { n2MainActivity });
                Object regionParams =  RegionParamsConstructor.newInstance(new Object[] { 0, 0, 600, 800, enumsWave[wave]});
                mtSetRegion.invoke(mEpdController, "aarddict", enumsRegion[region], regionParams, enumsMode[mode]);
            } catch (Exception e) {
                System.err.println("Failed: SetMode");
                System.err.println(e.toString());
                strN2EpdInit += "Failed: setMode: " + e.toString();
                e.printStackTrace();
            }
        }
    }

}