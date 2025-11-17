

import com.easyjava.RunDemoApplication;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunDemoApplication.class)  // 顺序调整一下
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
        Integer count = productInfoMapper.selectCount(query);
        System.out.println("查询结果数量: " + count);
    }

    @Test
    public void insert() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCode("10006");
        productInfo.setCreateTime(new Date());
        productInfo.setCreateDate(new Date());
        this.productInfoMapper.insert(productInfo);
        System.out.println(productInfo.getId());
    }

    @Test
    public void insertOrUpdate() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCode("10007");
        productInfo.setProductName("测试4");
        this.productInfoMapper.insertOrUpdate(productInfo);
        System.out.println(productInfo.getId());
    }

    @Test
    public void insertBatch() {
        List<ProductInfo> productInfoList = new ArrayList();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCreateTime(new Date());
        productInfo.setCode("10011");
        productInfoList.add(productInfo);

        productInfo = new ProductInfo();
        productInfo.setCreateTime(new Date());
        productInfo.setCode("10012");
        productInfoList.add(productInfo);

        this.productInfoMapper.insertBatch(productInfoList);
    }

    @Test
    public void insertBatchOrUpdate() {
        List<ProductInfo> productInfoList = new ArrayList();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCreateTime(new Date());
        productInfo.setCode("10011");
        productInfo.setCreateDate(new Date());
        productInfoList.add(productInfo);

        productInfo = new ProductInfo();
        productInfo.setCreateTime(new Date());
        productInfo.setCode("10012");
        productInfo.setCreateDate(new Date());
        productInfoList.add(productInfo);

        this.productInfoMapper.insertOrUpdateBatch(productInfoList);
    }

    @Test
    public void selectByKey() {
        ProductInfo productInfo1 = productInfoMapper.selectById(3);

        ProductInfo productInfo2 = productInfoMapper.selectByCode("10007");

        ProductInfo productInfo3 = productInfoMapper.selectBySkuTypeAndColorType(6, 0);

        System.out.println(productInfo1);
        System.out.println(productInfo2);
        System.out.println(productInfo3);
    }

    @Test
    public void updateByKey() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("update by 3");
        productInfoMapper.updateById(productInfo, 3);

        productInfo = new ProductInfo();
        productInfo.setProductName("update by code 10009");
        productInfoMapper.updateByCode(productInfo, "10009");

        productInfo = new ProductInfo();
        productInfo.setProductName("update by sku and color 1,2");
        Integer count = productInfoMapper.updateBySkuTypeAndColorType(productInfo, 1, 2);
        System.out.println(count);
    }


    @Test
    public void deleteByKey() {
        productInfoMapper.deleteById(7);
        productInfoMapper.deleteBySkuTypeAndColorType(1, 2);
        productInfoMapper.deleteByCode("10007");
    }
}