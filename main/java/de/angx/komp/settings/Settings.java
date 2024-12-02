package de.angx.komp.settings;

import de.angx.komp.Main;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.settings.elements.*;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import scala.util.parsing.combinator.PackratParsers;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class Settings {
    public enum FilterEnum {
        Erde,
        Bruchstein,
        Stein,
        Kohle,
        Redstone,
        Lapislazuli,
        Goldbarren,
        Eisenbarren,
        Smaragd,
        Diamant,
        Steinkohle,
        RedstoneErz,
        Lapislazulierz,
        Golderz,
        Eisenerz,
        Smaragderz,
        Diamanterz,
        Prismarinkristalle,
        Prismarinscherbe,
        Schwarzpulver,
        Enderperle,
        Lohenrute,
        Magmacreme,
        Ghastträne,
        Schleimball,
        Tintenbeutel,
        Knochen,
        Faden,
        Leder,
        Wolle
    }

    public enum KompEnum {
        StufeI,
        StufeII,
        StufeIII,
        StufeIV,
        StufeV,
        StufeVI,
        StufeVII
    }

    public static DropDownMenu<KompEnum> kompFilter;
    public static DropDownMenu<FilterEnum> customFilter;

    public static List<SettingsElement> draw() {
        List<SettingsElement> settings = new ArrayList<>();

        // BooleanElements

        final BooleanElement booleanAddonStatus = new BooleanElement("§a§lAddon Aktiv", new ControlElement.IconData("labymod/textures/buttons/accept.png"), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.booleanStatus = enabled;
                Main.instance.getConfig().addProperty("booleanStatus", enabled);
                Main.instance.saveConfig();
            }
        }, Main.booleanStatus);

        final BooleanElement booleanFilter = new BooleanElement("Filtern An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.filter = enabled;
                Main.instance.getConfig().addProperty("filter", enabled);
                Main.instance.saveConfig();
            }
        }, Main.filter);

        final BooleanElement booleanBonze = new BooleanElement("Bogen zu Bonze An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.bonze = enabled;
                Main.instance.getConfig().addProperty("bonze", enabled);
                Main.instance.saveConfig();
            }
        }, Main.bonze);

        final BooleanElement booleanCraft = new BooleanElement("Craft + Komprimieren An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.craftKomp = enabled;
                Main.instance.getConfig().addProperty("craftKomp", enabled);
                Main.instance.saveConfig();
            }
        }, Main.craftKomp);

        final BooleanElement booleanHotbarDrop = new BooleanElement("Droppen An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.drop = enabled;
                Main.instance.getConfig().addProperty("drop", enabled);
                Main.instance.saveConfig();
            }
        }, Main.drop);

        final BooleanElement booleanTrichterFilter = new BooleanElement("Trichter Filter An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.trichterFilter = enabled;
                Main.instance.getConfig().addProperty("trichterFilter", enabled);
                Main.instance.saveConfig();
            }
        }, Main.trichterFilter);

        final BooleanElement booleanTrichter = new BooleanElement("Trichter An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.trichterBoolean = enabled;
                Main.instance.getConfig().addProperty("trichterBoolean", enabled);
                Main.instance.saveConfig();
            }
        }, Main.trichterBoolean);

        final BooleanElement booleanInvSort = new BooleanElement("Inv Filter An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.invSort = enabled;
                Main.instance.getConfig().addProperty("invSort", enabled);
                Main.instance.saveConfig();
            }
        }, Main.invSort);

        final BooleanElement booleanHelfer = new BooleanElement("Evil Helfer An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.evilHelfer = enabled;
                Main.instance.getConfig().addProperty("evilHelfer", enabled);
                Main.instance.saveConfig();
            }
        }, Main.evilHelfer);

        final BooleanElement booleanBlockESP = new BooleanElement("BlockESP An/Aus", new ControlElement.IconData(Material.REDSTONE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enabled) {
                Main.blockESP = enabled;
                Main.instance.getConfig().addProperty("blockESP", enabled);
                Main.instance.saveConfig();
            }
        }, Main.blockESP);



        // KeyElements

        final KeyElement keyKomp = new KeyElement("Komprimieren", new ControlElement.IconData(Material.LEVER), Main.komp, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                    Main.komp = (accepted);
                    Main.instance.getConfig().addProperty("komp", Main.komp);
                    Main.instance.saveConfig();
            }
        });

        final KeyElement keyDauerKomp = new KeyElement("Dauer Komprimierer", new ControlElement.IconData(Material.LEVER), Main.dauerKomp, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.dauerKomp = (accepted);
                Main.instance.getConfig().addProperty("dauerKomp", Main.dauerKomp);
                Main.instance.saveConfig();
            }
        });


        final KeyElement keySign = new KeyElement("Signierung starten", new ControlElement.IconData(Material.LEVER), Main.signkey, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.signkey = (accepted);
                Main.instance.getConfig().addProperty("signkey", Main.signkey);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keySpawner = new KeyElement("Spawner Tool starten", new ControlElement.IconData(Material.LEVER), Main.spawnerTool, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.spawnerTool = (accepted);
                Main.instance.getConfig().addProperty("spawnerTool", Main.spawnerTool);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyFastPlace = new KeyElement("FastPlace", new ControlElement.IconData(Material.LEVER), Main.fastplace, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.fastplace = (accepted);
                Main.instance.getConfig().addProperty("fastplace", Main.fastplace);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyCraftSpeichern = new KeyElement("Crafting einlernen", new ControlElement.IconData(Material.LEVER), Main.craftEinspeichern, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.craftEinspeichern = (accepted);
                Main.instance.getConfig().addProperty("craftEinspeichern", Main.craftEinspeichern);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyUltraCraftingAn = new KeyElement("Crafting aktivieren", new ControlElement.IconData(Material.LEVER), Main.craftAn, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.craftAn = (accepted);
                Main.instance.getConfig().addProperty("craftAn", Main.craftAn);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyUltraCraftingAus = new KeyElement("Crafting deaktivieren", new ControlElement.IconData(Material.LEVER), Main.craftAus, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.craftAus = (accepted);
                Main.instance.getConfig().addProperty("craftAus", Main.craftAus);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyEntkomprimiererUnendlich = new KeyElement("Entkomprimierer starten/beenden", new ControlElement.IconData(Material.LEVER), Main.entkomprimiererUnendlich, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.entkomprimiererUnendlich = (accepted);
                Main.instance.getConfig().addProperty("entkomprimiererUnendlich", Main.entkomprimiererUnendlich);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyEntkomprimiererEinzeln = new KeyElement("Einzel Entkomprimierer", new ControlElement.IconData(Material.LEVER), Main.entkomprimiererEinzeln, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.entkomprimiererEinzeln = (accepted);
                Main.instance.getConfig().addProperty("entkomprimiererEinzeln", Main.invSort);
                Main.instance.saveConfig();
            }
        });

        final KeyElement keyKistenEinlernen = new KeyElement("Kisten einlernen", new ControlElement.IconData(Material.LEVER), Main.KistenEinlernen, new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                Main.KistenEinlernen = (accepted);
                Main.instance.getConfig().addProperty("KistenEinlernen", Main.KistenEinlernen);
                Main.instance.saveConfig();
            }
        });

        // StringElements

        final StringElement stringSign = new StringElement("Signierung", new ControlElement.IconData(Material.PAPER), Main.signText, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.signText = (accepted);
                Main.instance.getConfig().addProperty("signText", Main.signText);
                Main.instance.saveConfig();
            }
        });

        final StringElement stringInv = new StringElement("Item welches behalten wird [ID]", new ControlElement.IconData(Material.PAPER), Main.invText, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.invText = (accepted);
                Main.instance.getConfig().addProperty("invText", Main.invText);
                Main.instance.saveConfig();
            }
        });

        final StringElement stringGeschwindigkeit = new StringElement("Geschwindigkeit [Experimentell]", new ControlElement.IconData(Material.PAPER), Main.msGeschwindigkeit, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.msGeschwindigkeit = (accepted);
                Main.instance.getConfig().addProperty("msGeschwindigkeit", Main.msGeschwindigkeit);
                Main.instance.saveConfig();
            }
        });

        final StringElement stringSammelradius = new StringElement("Sammelradius [0-15]", new ControlElement.IconData(Material.PAPER), Main.sammelradius, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.sammelradius = (accepted);
                Main.instance.getConfig().addProperty("sammelradius", Main.sammelradius);
                Main.instance.saveConfig();
            }
        });

        final StringElement stringMSGWebhook = new StringElement("MSG Webhook", new ControlElement.IconData(Material.PAPER), Main.msgWebhook, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.msgWebhook = (accepted);
                Main.instance.getConfig().addProperty("msgWebhook", Main.msgWebhook);
                Main.instance.saveConfig();
            }
        });

        final StringElement stringBlockID = new StringElement("BlockID", new ControlElement.IconData(Material.PAPER), Main.blockESPID, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
                Main.blockESPID = (accepted);
                Main.instance.getConfig().addProperty("blockESPID", Main.blockESPID);
                Main.instance.saveConfig();
            }
        });

        // DropDownMenu

        customFilter = new DropDownMenu<FilterEnum>("Filter", 0, 0, 0, 0).fill(FilterEnum.values());
        DropDownElement<FilterEnum> customFilterMenu = new DropDownElement<>("Filter", customFilter);
        customFilter.setSelected(FilterEnum.Bruchstein);

        kompFilter = new DropDownMenu<KompEnum>("Komprimierungsstufe", 0, 0, 0, 0).fill(KompEnum.values());
        DropDownElement<FilterEnum> KompFilterMenu = new DropDownElement<>("Komprimierungsstufe", kompFilter);
        kompFilter.setSelected(KompEnum.StufeI);

        // Einstellungskategorien
        ListContainerElement KomprimierungsEinstellung = new ListContainerElement("§lKomprimierungs Einstellungen",new ControlElement.IconData(Material.WORKBENCH));
        ListContainerElement SignierungsEinstellung = new ListContainerElement("§lSignierungs Einstellungen",new ControlElement.IconData(Material.EMPTY_MAP));
        ListContainerElement SpawnerEinstellung = new ListContainerElement("§lSpawner Tool Einstellungen",new ControlElement.IconData(Material.MOB_SPAWNER));
        ListContainerElement FastPlaceEinstellung = new ListContainerElement("§lFast Place Einstellungen",new ControlElement.IconData(Material.GRASS));
        ListContainerElement InvSortEinstellung = new ListContainerElement("§lInv Filter Einstellungen",new ControlElement.IconData(Material.LAVA_BUCKET));
        //ListContainerElement CraftEinstellung = new ListContainerElement("§lCrafting Einstellungen",new ControlElement.IconData(Material.WORKBENCH));
        ListContainerElement BonzeBogen = new ListContainerElement("§lBonze-Bogen", new ControlElement.IconData(Material.DIAMOND_SWORD));
        ListContainerElement EntkomprimiererEinstellung = new ListContainerElement("§lEntkomprimierer", new ControlElement.IconData(Material.WORKBENCH));
        ListContainerElement TrichterEinstellung = new ListContainerElement("§lTrichter konfigurieren", new ControlElement.IconData(Material.HOPPER));
        ListContainerElement KistenEinstellungen = new ListContainerElement("§lKisten Einstellungen", new ControlElement.IconData(Material.CHEST));
        ListContainerElement MSGEinstellungen = new ListContainerElement("§lMSG Einstellungen", new ControlElement.IconData(Material.PAPER));
        ListContainerElement EvilHelfer = new ListContainerElement("§lEvil Helfer", new ControlElement.IconData(Material.NETHERRACK));
        ListContainerElement BlockESP = new ListContainerElement("§lBlockESP", new ControlElement.IconData(Material.WEB));



        // Implementierung

        settings.add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        settings.add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));

        settings.add(booleanAddonStatus);
        //settings.add(KistenEinstellungen);
        //KistenEinstellungen.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        //KistenEinstellungen.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        //KistenEinstellungen.getSubSettings().add(new HeaderElement(""));
        //KistenEinstellungen.getSubSettings().add(new HeaderElement("§lKisten Einstellungen"));
        //KistenEinstellungen.getSubSettings().add(keyKistenEinlernen);

        settings.add(new HeaderElement("§lNützliche Funktionen:"));

        settings.add(KomprimierungsEinstellung);
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement(""));
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§lKomprimierungs Einstellungen"));

        KomprimierungsEinstellung.getSubSettings().add(EntkomprimiererEinstellung);
        EntkomprimiererEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        EntkomprimiererEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        EntkomprimiererEinstellung.getSubSettings().add(new HeaderElement(""));
        EntkomprimiererEinstellung.getSubSettings().add(new HeaderElement("§lEntkomprimierungs Einstellungen"));
        EntkomprimiererEinstellung.getSubSettings().add(keyEntkomprimiererEinzeln);
        EntkomprimiererEinstellung.getSubSettings().add(keyEntkomprimiererUnendlich);

        KomprimierungsEinstellung.getSubSettings().add(KompFilterMenu);
        KomprimierungsEinstellung.getSubSettings().add(keyKomp);
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§l"));
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§lDauerKomp"));
        KomprimierungsEinstellung.getSubSettings().add(keyDauerKomp);
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§lAchtung - Einstellung auf eigene Gefahr:"));
        KomprimierungsEinstellung.getSubSettings().add(new HeaderElement("§lEmpfohlen: 200 - 300"));
        KomprimierungsEinstellung.getSubSettings().add(stringGeschwindigkeit);

        settings.add(FastPlaceEinstellung);
        FastPlaceEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        FastPlaceEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        FastPlaceEinstellung.getSubSettings().add(new HeaderElement(""));
        FastPlaceEinstellung.getSubSettings().add(new HeaderElement("§lFast Place Einstellungen"));
        FastPlaceEinstellung.getSubSettings().add(keyFastPlace);

        settings.add(InvSortEinstellung);
        InvSortEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        InvSortEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        InvSortEinstellung.getSubSettings().add(new HeaderElement(""));
        InvSortEinstellung.getSubSettings().add(new HeaderElement("§lInv Filter Einstellungen"));
        InvSortEinstellung.getSubSettings().add(booleanInvSort);
        InvSortEinstellung.getSubSettings().add(stringInv);

        settings.add(BonzeBogen);
        BonzeBogen.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        BonzeBogen.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        BonzeBogen.getSubSettings().add(new HeaderElement(""));
        BonzeBogen.getSubSettings().add(new HeaderElement("§lBonze-Bogen Einstellungen"));
        BonzeBogen.getSubSettings().add(booleanBonze);

        settings.add(TrichterEinstellung);
        TrichterEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        TrichterEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        TrichterEinstellung.getSubSettings().add(new HeaderElement(""));
        TrichterEinstellung.getSubSettings().add(new HeaderElement("§lTrichter Einstellungen"));
        TrichterEinstellung.getSubSettings().add(booleanTrichter);
        TrichterEinstellung.getSubSettings().add(booleanTrichterFilter);
        TrichterEinstellung.getSubSettings().add(stringSammelradius);

        settings.add(MSGEinstellungen);
        MSGEinstellungen.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        MSGEinstellungen.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        MSGEinstellungen.getSubSettings().add(new HeaderElement(""));
        MSGEinstellungen.getSubSettings().add(new HeaderElement("§lMSG Einstellungen"));
        MSGEinstellungen.getSubSettings().add(stringMSGWebhook);

        /*
        settings.add(CraftEinstellung);
        CraftEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        CraftEinstellung.getSubSettings().add(new HeaderElement(""));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§lCrafting Einstellungen"));
        CraftEinstellung.getSubSettings().add(booleanCraft);
        CraftEinstellung.getSubSettings().add(booleanHotbarDrop);
        CraftEinstellung.getSubSettings().add(new HeaderElement(""));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§lCrafting"));
        CraftEinstellung.getSubSettings().add(keyCraftSpeichern);
        CraftEinstellung.getSubSettings().add(keyUltraCraftingAn);
        CraftEinstellung.getSubSettings().add(keyUltraCraftingAus);
        CraftEinstellung.getSubSettings().add(new HeaderElement(""));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§lErklärung:"));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§l1. Baue die Crafting Station aus dem Discord Channel ab. Wichtig: Richtung Norden!"));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§l2. Lege einen Speicher Hotkey ein und leg die Items ins Craftingfeld bis sie droppen."));
        CraftEinstellung.getSubSettings().add(new HeaderElement("§l3. Aktiviere das Crafting und deaktiviere es wenn du fertig bist."));
        */

        settings.add(SpawnerEinstellung);
        SpawnerEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        SpawnerEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        SpawnerEinstellung.getSubSettings().add(new HeaderElement(""));
        SpawnerEinstellung.getSubSettings().add(new HeaderElement("§lSpawner Tool Einstellungen"));
        SpawnerEinstellung.getSubSettings().add(booleanFilter);
        SpawnerEinstellung.getSubSettings().add(customFilterMenu);
        SpawnerEinstellung.getSubSettings().add(keySpawner);

        settings.add(EvilHelfer);
        EvilHelfer.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        EvilHelfer.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        EvilHelfer.getSubSettings().add(new HeaderElement(""));
        EvilHelfer.getSubSettings().add(new HeaderElement("§lEvil Helfer Einstellungen"));
        EvilHelfer.getSubSettings().add(booleanHelfer);
        EvilHelfer.getSubSettings().add(new HeaderElement(""));

        settings.add(BlockESP);
        BlockESP.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        BlockESP.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        BlockESP.getSubSettings().add(new HeaderElement(""));
        BlockESP.getSubSettings().add(new HeaderElement("§lBlockESP Einstellungen"));
        BlockESP.getSubSettings().add(booleanBlockESP);
        BlockESP.getSubSettings().add(stringBlockID);
        BlockESP.getSubSettings().add(new HeaderElement(""));

        //settings.add(new HeaderElement("§lKisten Einstellung benötigt:"));

        //settings.add(SignierungsEinstellung);
        //SignierungsEinstellung.getSubSettings().add(new HeaderElement("§8§l§kggg§7§l MAGIE §8§l§kggg"));
        //SignierungsEinstellung.getSubSettings().add(new HeaderElement("§l...Zum Glück habe ich Jahrelange Minecraft Erfahrung!..."));
        //SignierungsEinstellung.getSubSettings().add(new HeaderElement(""));
        //SignierungsEinstellung.getSubSettings().add(new HeaderElement("§lSignierungs Einstellungen"));
        //SignierungsEinstellung.getSubSettings().add(stringSign);
        //SignierungsEinstellung.getSubSettings().add(keySign);

        settings.add(new HeaderElement("Bug entdeckt oder Ideen? Bitte melden!"));
        settings.add(new HeaderElement("§aMagie " + Main.version));

        return settings;
    }
}
