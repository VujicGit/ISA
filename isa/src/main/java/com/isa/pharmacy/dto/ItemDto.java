package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDto {

    private String name;
    private String code;
    private String composition;
    private String manufacturer;
    private String note;
    private String dailyDose;
    private String contraindications;
    private List<IngredientDto> ingredients;
    private int quantity;

    public ItemDto() {

    }

    public ItemDto(String name, String code, String composition, String manufacturer, String note, String dailyDose, String contraindications, List<IngredientDto> ingredients, int quantity) {
        this.name = name;
        this.code = code;
        this.composition = composition;
        this.manufacturer = manufacturer;
        this.note = note;
        this.dailyDose = dailyDose;
        this.contraindications = contraindications;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public ItemDto(Item item) {
        this.name = item.getDrug().getName();
        this.code = item.getDrug().getCode();
        this.composition = item.getDrug().getComposition();
        this.manufacturer = item.getDrug().getManufacturer();
        this.note = item.getDrug().getNote();
        this.dailyDose = item.getDrug().getDailyDose();
        this.contraindications = item.getDrug().getContraindications();
        this.ingredients = item.getDrug().getIngredients().stream().map(IngredientDto::new).collect(Collectors.toList());
        this.quantity = item.getQuantity();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getComposition() {
        return composition;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNote() {
        return note;
    }

    public String getDailyDose() {
        return dailyDose;
    }

    public String getContraindications() {
        return contraindications;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDailyDose(String dailyDose) {
        this.dailyDose = dailyDose;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
