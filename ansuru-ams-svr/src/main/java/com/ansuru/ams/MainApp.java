package com.ansuru.ams;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args)throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        AssetMapper userService = (AssetMapper) app.getBean("assetMapper");
        System.out.println("userService = " + userService);

//        Asset asset = new Asset();
//        asset.setAssetName("test123");
//        asset.setAssetCode("321312");
//        userService.insert(asset);
//        System.out.println("asset1 = " + asset);

        AssetExample assetExample = new AssetExample();

        assetExample.createCriteria() .andAssetNameEqualTo("adf12312");
        assetExample.or().andAssetNameEqualTo("456");

        List<Asset> assets = userService.selectByExample(assetExample);
        System.out.println("assets = " + assets);

    }
}
