package model;

import controller.fileHandlers.ConfigHandler;

public interface MemoryHandler {
    String apply(String calculationText, ConfigHandler configHandler);
}
