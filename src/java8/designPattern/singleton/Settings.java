package java8.designPattern.singleton;

public class Settings {

    private Settings() { }


    /** 싱글톤 패턴 구현 방법 1 */
//    private static Settings instance;

//    public static Settings getInstance() {
//        if (instance == null) {
//            return new Settings();
//        }
//
//        return instance;
//    }

    /** 싱글톤 패턴 구현 방법 2 */
//    private static Settings instance;

//    public static synchronized Settings getInstance() {
//        if (instance == null) {
//            return new Settings();
//        }
//
//        return instance;
//    }

    /** 싱글톤 패턴 구현 방법 3 */
//    private static final Settings INSTANCE = new Settings();
//
//    public static Settings getInstance() {
//        return INSTANCE;
//    }

    /** 싱글톤 패턴 구현 방법 4 */
//    private static volatile Settings instance;
//
//    public static Settings getInstance() {
//        if (instance == null) {
//            synchronized (Settings.class) {
//                if (instance == null) {
//                    return new Settings();
//                }
//            }
//        }
//
//        return instance;
//    }

    /** 싱글톤 패턴 구현 방법 5 */
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
