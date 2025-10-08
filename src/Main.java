//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Modpack mcEternal = new Modpack("McEternal 2");
    Modpack ATM10 = new Modpack("ATM10");

    mcEternal.addMod("1.12.2", "ThaumCraft");

    mcEternal.listMods();
}
