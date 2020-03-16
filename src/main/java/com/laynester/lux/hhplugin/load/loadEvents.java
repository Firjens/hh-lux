package com.laynester.lux.hhplugin.load;

import com.eu.habbo.Emulator;
import com.eu.habbo.plugin.EventListener;
import com.laynester.lux.Lux;
import com.laynester.lux.events.*;
import com.laynester.lux.hhcore.log.error;
import com.laynester.lux.hhcore.log.generic;
import com.laynester.lux.roomManager.buildHeight;
import com.laynester.lux.roomManager.frozenRoom;
import com.laynester.lux.roomManager.setState;

public class loadEvents implements EventListener {
    public static void loadEvents() {
        long startTimeModuleCommandManager = System.currentTimeMillis();
        try {
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new LoginEvents());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new UserTalk());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new CreditsReceived());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new PointsReceived());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new RoomLoaded());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new RoomQuit());

            // Room Manager
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new frozenRoom());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new buildHeight());
            Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new setState());
            // Emulator.getPluginManager().registerEvents(Lux.INSTANCE, new brb());

            generic.logMessage("Event Manager -> " + (System.currentTimeMillis () - startTimeModuleCommandManager) + "ms -> OK");
        } catch (Exception ex) {
            generic.logMessage("Event Manager -> ERROR");
            error.logError("eventManager","Lux > Emulator Load > Load Events","", 2, false, ex);
        }
    }
}
