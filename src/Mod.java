public class Mod {
    private String modName;
    private String modVersion;

    public Mod(String modName, String modVersion) {
        this.modName = modName;
        this.modVersion = modVersion;

    }

    @Override
    public String toString() {
        return "[" + modVersion + "] " + modName;
    }

    public String getModName() {
        return modName;
    }

    public String getModVersion() {
        return modVersion;
    }
}
