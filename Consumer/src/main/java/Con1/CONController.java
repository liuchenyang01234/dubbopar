package Con1;

import Ser.NameSer;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CONController {
    // @Autowired
    private NameSer nameSer;
    @Resource
    public void setAttachmentDao( NameSer nameSer) {
        this.nameSer = nameSer;
    }
    @RequestMapping("/hello")
    public String hello(String username)
    {
      Object object=nameSer.name(username);

        System.out.println("controller");
        return "hello";
    }
}