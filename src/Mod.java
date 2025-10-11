public class Mod {
    private String modName;
    //private String modVersion;

    public Mod(String modName) {
        this.modName = modName;
        //modVersion = "1.20.1";

    }

    @Override
    public String toString() {
        return modName + "\n";
    }

    public String getModName() {
        return modName;
    }

    /*public String getModVersion() {
        return modVersion;
    }*/
}
