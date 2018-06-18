package org.softc.armoryexpansion;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.softc.armoryexpansion.dynamic_systems.dynamic_materials.Config;
import org.softc.armoryexpansion.dynamic_systems.dynamic_materials.MaterialRegistration;

@Mod(
        modid = ArmoryExpansion.MODID,
        name = ArmoryExpansion.NAME,
        version = ArmoryExpansion.VERSION,
        dependencies = "required-after:tconstruct; " +
                "required-after:conarm; " +
                "after:basemetals; " +
                "after:modernmetals; " +
                "after:fantasymetals; " +
                "after:plustic; " +
                "after:moartinkers; " +
                "after:taiga;" +
                "after:acintegration;" +
                "after:BloodArsenal;" +
                "after:enderiointegrationtic;" +
                "after:integrationforegoing;" +
                "after:twilightforest;" +
                "after:pewter;" +
                "after:extrautils2;" +
                "after:mysticalagriculture;" +
                "after:mysticalagradditions;" +
                "after:silentgems;" +
                "after:botania;"
)
public class ArmoryExpansion
{
    static final String MODID = "armoryexpansion";
    static final String NAME = "Armory Expansion";
    static final String VERSION = "0.1.5";

    public static Configuration config;
    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
        config = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();

        MaterialRegistration.registerFromToolMaterialStat();

    }

//    @Mod.EventHandler
//    public void init(FMLInitializationEvent event)
//    {
//
//    }
}