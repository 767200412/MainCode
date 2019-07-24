package comdemo.example.dell.uitestdemo2.bean;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.io.Serializable;

import comdemo.example.dell.uitestdemo2.R;

public class GoodsEntity implements Serializable {
    public int imgPath;//图片地址
    public String goodsName;//货物名称
    public String goodsPrice;//货物价格

    public GoodsEntity() {
    }

    public GoodsEntity(int imgPath, String goodsName, String goodsPrice) {
        this.imgPath = imgPath;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public int getImgPath() {
        return imgPath;
    }


    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "imgPath='" + imgPath + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }
}
