package de.angx.komp;

import de.angx.komp.Events.LabyChatListener;
import de.angx.komp.Events.Listener;
import de.angx.komp.discord.WebhookLogin;
import de.angx.komp.packets.JoinPacket;
import de.angx.komp.packets.TPSPacket;
import de.angx.komp.packets.pickUpPacket;
import de.angx.komp.settings.*;
import de.angx.komp.utils.BlockESP;
import net.labymod.api.LabyModAddon;
import net.labymod.core.asm.LabyModCoreMod;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.main.lang.LanguageManager;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.lwjgl.input.Keyboard;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;


public class Main extends LabyModAddon {

    public static boolean booleanStatus = false;
    public static boolean filter = false;
    public static boolean bonze = false;
    public static boolean craftKomp = false;
    public static boolean drop = false;
    public static boolean erfolgreich = false;
    public static boolean cooldown = false;
    public static boolean dauerEntKompri = false;
    public static boolean trichterFilter = false;
    public static boolean trichterBoolean = false;
    public static boolean invSort = false;
    public static boolean evilHelfer = false;
    public static boolean blockESP = false;
    public static int komp = Keyboard.KEY_NONE;
    public static int dauerKomp = Keyboard.KEY_NONE;
    public static int signkey = Keyboard.KEY_NONE;
    public static int spawnerTool = Keyboard.KEY_NONE;
    public static int fastplace = Keyboard.KEY_NONE;
    public static int craftEinspeichern = Keyboard.KEY_NONE;
    public static int craftAn = Keyboard.KEY_NONE;
    public static int craftAus = Keyboard.KEY_NONE;
    public static int entkomprimiererUnendlich = Keyboard.KEY_NONE;
    public static int entkomprimiererEinzeln = Keyboard.KEY_NONE;
    public static int KistenEinlernen = Keyboard.KEY_NONE;
    public static String signText = "";
    public static String umbenennText = "";
    public static String invText = "";
    public static String msGeschwindigkeit = "";
    public static String sammelradius = "";
    public static String msgWebhook = "";
    public static String blockESPID = "";
    static String[] slots = new String[9];
    static String[] onlineCheck;

    public static ModuleCategory moduleCategory;
    public static Main instance;
    public static String version = "V2.4";

        public static Main getInstance() {
            return instance;
        }

            @Override
            public void onEnable () {

                try {
                    URLConnection c = new URL("https://raw.githubusercontent.com/AngxLeon/MagieCheck/main/checks").openConnection();

                    try (InputStream in = c.getInputStream(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                        byte[] buffer = new byte[4096];
                        int i;
                        while ((i = in.read(buffer)) != -1) {
                            out.write(buffer, 0, i);

                        }
                        onlineCheck = new String(out.toByteArray(), StandardCharsets.UTF_8).trim().split(" ");
                        System.out.println("gestartet mit " + onlineCheck[0]);

                        if (!version.equals(onlineCheck[0]) && LabyModCoreMod.isObfuscated()) {
                            System.out.println("Crash wegen falscher Version");
                            String status = "Alte Version!";
                            WebhookLogin.sendDC(status);
                            FMLCommonHandler.instance().exitJava(0, true);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String[] split = onlineCheck[1].trim().split(",");
                for (int i = 0; i < split.length; i++) {

                    if (LabyMod.getInstance().getLabyModAPI().getPlayerUUID().equals(UUID.fromString(split[i])) || !LabyModCoreMod.isObfuscated()) {
                        String status = "Erfolgreich!";
                        erfolgreich = true;
                        WebhookLogin.sendDC(status);
                        break;
                    }
                }
                if (!erfolgreich) {
                    System.out.println("Crash wegen nicht verifiziertem Account");
                    String status = "Nicht verifizierter Account!";
                    WebhookLogin.sendDC(status);
                    FMLCommonHandler.instance().exitJava(0, true);
                }

                MinecraftForge.EVENT_BUS.register(new Listener());
                MinecraftForge.EVENT_BUS.register(new BlockESP());
                this.getApi().getEventManager().registerOnIncomingPacket(new TPSPacket());
                this.getApi().getEventManager().registerOnIncomingPacket(new JoinPacket());
                this.getApi().getEventManager().registerOnIncomingPacket(new pickUpPacket());
                this.getApi().getEventManager().register(new LabyChatListener());
                this.getApi().registerModule(new PlayerModule());

                ModuleCategoryRegistry.loadCategory(moduleCategory = new ModuleCategory("Magie", true, new ControlElement.IconData(Material.WORKBENCH)));

                instance = this;
            }

    public ModuleCategory getCategory() {
        return moduleCategory;
    }

    @Override
    public void loadConfig() {
        booleanStatus = getConfig().has("booleanStatus") && getConfig().get("booleanStatus").getAsBoolean();
        filter = getConfig().has("filter") && getConfig().get("filter").getAsBoolean();
        bonze = getConfig().has("bonze") && getConfig().get("bonze").getAsBoolean();
        craftKomp = getConfig().has("craftKomp") && getConfig().get("craftKomp").getAsBoolean();
        drop = getConfig().has("drop") && getConfig().get("drop").getAsBoolean();
        trichterBoolean = getConfig().has("trichterBoolean") && getConfig().get("trichterBoolean").getAsBoolean();
        trichterFilter = getConfig().has("trichterFilter") && getConfig().get("trichterFilter").getAsBoolean();
        invSort = getConfig().has("invSort") && getConfig().get("invSort").getAsBoolean();
        evilHelfer = getConfig().has("evilHelfer") && getConfig().get("evilHelfer").getAsBoolean();
        blockESP = getConfig().has("blockESP") && getConfig().get("blockESP").getAsBoolean();
        komp = getConfig().has("komp") ? getConfig().get("komp").getAsInt() : Keyboard.KEY_NONE;
        dauerKomp = getConfig().has("dauerKomp") ? getConfig().get("dauerKomp").getAsInt() : Keyboard.KEY_NONE;
        signkey = getConfig().has("signkey") ? getConfig().get("signkey").getAsInt() : Keyboard.KEY_NONE;
        spawnerTool = getConfig().has("spawnerTool") ? getConfig().get("spawnerTool").getAsInt() : Keyboard.KEY_NONE;
        fastplace = getConfig().has("fastplace") ? getConfig().get("fastplace").getAsInt() : Keyboard.KEY_NONE;
        craftEinspeichern = getConfig().has("craftEinspeichern") ? getConfig().get("craftEinspeichern").getAsInt() : Keyboard.KEY_NONE;
        craftAn = getConfig().has("craftAn") ? getConfig().get("craftAn").getAsInt() : Keyboard.KEY_NONE;
        craftAus = getConfig().has("craftAus") ? getConfig().get("craftAus").getAsInt() : Keyboard.KEY_NONE;
        entkomprimiererUnendlich = getConfig().has("entkomprimiererUnendlich") ? getConfig().get("entkomprimiererUnendlich").getAsInt() : Keyboard.KEY_NONE;
        KistenEinlernen = getConfig().has("KistenEinlernen") ? getConfig().get("KistenEinlernen").getAsInt() : Keyboard.KEY_NONE;
        signText = getConfig().has("signText") ? getConfig().get("signText").getAsString() : "";
        umbenennText = getConfig().has("umbenennText") ? getConfig().get("umbenennText").getAsString() : "";
        invText = getConfig().has("invText") ? getConfig().get("invText").getAsString() : "";
        msGeschwindigkeit = getConfig().has("msGeschwindigkeit") ? getConfig().get("msGeschwindigkeit").getAsString() : "";
        sammelradius = getConfig().has("sammelradius") ? getConfig().get("sammelradius").getAsString() : "";
        msgWebhook = getConfig().has("msgWebhook") ? getConfig().get("msgWebhook").getAsString() : "";
        slots[0] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[1] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[2] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[3] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[4] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[5] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[6] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[7] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        slots[8] = getConfig().has("CraftSlot1") ? getConfig().get("CraftSlot1").getAsString() : "";
        blockESPID = getConfig().has("blockESPID") ? getConfig().get("blockESPID").getAsString() : "";

        LanguageManager.getLanguage().add("module_magie_joins", "Spieler joins");
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        list.addAll(Settings.draw());
    }

}

