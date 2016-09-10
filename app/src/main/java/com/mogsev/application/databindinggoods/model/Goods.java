package com.mogsev.application.databindinggoods.model;

public class Goods {

    private long id;
    private String title;
    private String description;
    private String country;
    private int price;
    private int pos;

    public Goods() {

    }

    public Goods(long id, String title, String country, int price) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (price != goods.price) return false;
        if (!title.equals(goods.title)) return false;
        if (description != null ? !description.equals(goods.description) : goods.description != null)
            return false;
        return country.equals(goods.country);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + country.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
