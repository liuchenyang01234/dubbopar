package RedisOp;


import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
