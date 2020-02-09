package com.example.hydrana;

public class Drink {
    private String Name, Image, Price, MenuId, Description, Discount;

    public Drink() {
    }

    public Drink(String name, String image, String price, String menuId, String description, String discount) {
        Name = name;
        Image = image;
        Price = price;
        MenuId = menuId;
        Description = description;
        Discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}

