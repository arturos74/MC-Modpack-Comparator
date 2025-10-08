import java.util.ArrayList;
import java.util.List;

public class Modpack {
    private String modpackName;
    private int modAmount;
    private List<Mod> mods;


    public Modpack(String modpackName) {
        this.modpackName = modpackName;
        modAmount = 0;
        mods = new ArrayList<>();
    }

    public void addMod(String modVersion, String modName) {
        Mod mod = new Mod(modName, modVersion);
        mods.add(mod);
    }

    public void listMods() {
        System.out.println(mods.toString());
    }

    public String getModpackName() {
        return modpackName;
    }

    public int getModAmount() {
        return modAmount;
    }

}
