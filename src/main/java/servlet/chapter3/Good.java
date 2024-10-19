package servlet.chapter3;

public class Good {
    private String name;
    private Double price;
    private Integer id;
    private int count;

    public Good(int id, String name, double value) {
        this.id = id;
        this.name = name;
        this.price = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "{\"id\":"+ id +",\"name\":\""+ name +"\",\"price\":"+price+"}";
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}
