

import com.easyjava.RunApplication;
import com.easyjava.entity.po.ProductInfo;
import com.easyjava.entity.query.ProductInfoQuery;
import com.easyjava.mappers.ProductInfoMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class)  // 顺序调整一下
public class MapperTest {

    @Resource
    private ProductInfoMapper<ProductInfo, ProductInfoQuery> productInfoMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void selectList() {
        ProductInfoQuery query = new ProductInfoQuery();
//        query.setId(1);
//        query.setCreateTimeStart("2025-10-31");
        query.setCodeFuzzy("3");
        List<ProductInfo> dataList = productInfoMapper.selectList(query);
        for (ProductInfo productInfo : dataList) {
            System.out.println(productInfo);
        }
        Long count = productInfoMapper.selectCount(query);
        System.out.println("查询结果数量: " + count);
    }

    @Test
    public void insert() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCode("10006");
        productInfo.setSkuType(6);
        productInfo.setColorType(0);
        productInfo.setCreateTime(new Date());
        productInfo.setCreateDate(new Date());
        this.productInfoMapper.insert(productInfo);
        System.out.println(productInfo.getId());
    }
}