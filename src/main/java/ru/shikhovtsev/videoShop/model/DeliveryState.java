package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryState {

    CREATE("Создан"),
    IN_PROCESSING("В обработке"),
    CANCELED("Отменен"),
    WAY("В пути"),
    DELIVER("Доставлен");

    public String description;
}
