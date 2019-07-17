package nihao;

import Entity.Category;
import Ser.CategorySer;
import com.github.pagehelper.PageHelper;
import nihao.Mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerIml implements CategorySer {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategoty() {

        PageHelper.offsetPage(0, 5);
        List<Category> categoryList=categoryMapper.Categorylist();
        return categoryList;
    }



}
