package model;

import controller.file_handlers.ConfigHandler;

public interface MemoryHandler {
    String apply(String calculationText, ConfigHandler configHandler);
}
