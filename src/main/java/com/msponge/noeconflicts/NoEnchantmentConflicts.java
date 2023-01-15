package com.msponge.noeconflicts;

import com.msponge.noeconflicts.config.Config;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoEnchantmentConflicts implements ModInitializer {

	public static final String MOD_ID = "noeconflicts";
    public static final String MOD_NAME = "NoEnchantmentConflicts";
    public static final String MOD_VER = "1.3.0";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("noeconflicts");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		log(Level.INFO, "version " + MOD_VER);
        Config.loadConfig();
        log(Level.INFO, "Initialized successfully.");
	}

	public static void log(Level level, String message){
        if(Config.INSTANCE.log == null || level.isMoreSpecificThan(Config.INSTANCE.log))
            LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }
}
