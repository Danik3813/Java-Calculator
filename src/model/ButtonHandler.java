package model;

import controller.file_handlers.ConfigHandler;;

public interface ButtonHandler {
    String apply(String text, ConfigHandler configHandler);
}
