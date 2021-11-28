package com.vafgrant.qa.test.configs;

public class ReaderManager {

    private static final ReaderManager readerManager = new ReaderManager();
    protected static GUIConfig guiConfigReader;

    private ReaderManager() { }

    public static ReaderManager getInstance( ) {
        return readerManager;
    }
    public GUIConfig getGUIConfigReader() { return (guiConfigReader == null) ? new GUIConfig() : guiConfigReader; }

}
