package nihao;

import Entity.Category;
import Ser.CategorySer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerTest {

    @Autowired
    CategorySer categorySer;

    @RequestMapping("/hello")
    public List<Category> hello()
    {
        List<Category> categoryList=categorySer.listCategoty();

        return categoryList;

    }

}
