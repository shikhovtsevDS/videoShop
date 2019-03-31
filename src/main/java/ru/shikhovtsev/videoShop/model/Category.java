package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Category {

    CAMERA("Camera"),
    TV("Television"),
    MOVIE("Movie"),
    PHOTO("Photographic equipment");

    private String name;
}
