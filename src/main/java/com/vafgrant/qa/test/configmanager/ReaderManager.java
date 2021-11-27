package com.vafgrant.qa.test.configmanager;

public class ReaderManager {

    private static ReaderManager readerManager = new ReaderManager();
    private static GUIConfig guiConfigReader;

    private ReaderManager() { }

    public static ReaderManager getInstance( ) {
        return readerManager;
    }
    public GUIConfig getGUIConfigReader() { return (guiConfigReader == null) ? new GUIConfig() : guiConfigReader; }

}
