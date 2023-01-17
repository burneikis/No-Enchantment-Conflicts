package com.msponge.noeconflicts.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.msponge.noeconflicts.NoEnchantmentConflicts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.logging.log4j.Level;

public class Config{
    public static Config INSTANCE = new Config();

    private static final File configDir = new File("config");
    private static final File configFile = new File("config/" + NoEnchantmentConflicts.MOD_ID + "_config.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().serializeNulls().create();

    public boolean DamageEnchantments = true;
    public boolean ProtectionEnchantments = true;
    public boolean InfinityEnchantment = true;
    public boolean PiercingEnchantment = true;
    public transient Level log;

    public static void loadConfig(){
        try{
            configDir.mkdirs();
            if(configFile.createNewFile()){
                FileWriter fw = new FileWriter(configFile);
                fw.append(gson.toJson(INSTANCE));
                fw.close();
                NoEnchantmentConflicts.log(Level.INFO, "Default config generated.");
            }else{
                FileReader fr = new FileReader(configFile);
                INSTANCE = gson.fromJson(fr, Config.class);
                fr.close();
                NoEnchantmentConflicts.log(Level.INFO, "Config loaded.");
                return;
            }
        }catch(Exception e){
            NoEnchantmentConflicts.log(Level.WARN, "Error loading config, using default values.");
        }
    }

    public static void saveConfigs(){
        try{
            configDir.mkdirs();
            FileWriter fw = new FileWriter(configFile);
            fw.append(gson.toJson(INSTANCE));
            fw.close();
            NoEnchantmentConflicts.log(Level.INFO, "Config saved.");
        }catch(Exception e){
            NoEnchantmentConflicts.log(Level.ERROR, "Error saving config");
        }
    }
}