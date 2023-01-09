package Case_modul2.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String loaisanpham;

    public Category() {
    }

    public Category(int id, String loaisanpham) {
        this.id = id;
        this.loaisanpham = loaisanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", loai sản phẩm='" + loaisanpham + '\'' +
                '}';
    }
}
