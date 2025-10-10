import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Modpack {
    private String modpackPath;
    private String modpackName;
    private List<Mod> mods;


    public Modpack(String modpackName, String modpackPath) {
        this.modpackName = modpackName;
        this.modpackPath = modpackPath;
        mods = new ArrayList<>();

        File folder = new File(this.modpackPath);
        File[] files = folder.listFiles();

        if(files != null) {
            for(File file : files) {
                if(file.isFile() && file.getName().endsWith(".jar")) {
                    String filename = file.getName().replace(".jar", "");
                    Mod mod = new Mod(filename);
                    mods.add(mod);
                }
            }
        }

    }

    public void addMod (String modName) {
        Mod mod = new Mod(modName);
        mods.add(mod);
    }

    public String listMods() {
        return mods.toString();
    }

    public String getModpackPath() {
        return modpackPath;
    }

    public String getModpackName() {
        return modpackName;
    }

    public int getModAmount() {
        return mods.size();
    }

}
