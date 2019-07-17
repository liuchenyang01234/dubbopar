package nihao.Mapper;

import Entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    public List<Category>  Categorylist();
}
