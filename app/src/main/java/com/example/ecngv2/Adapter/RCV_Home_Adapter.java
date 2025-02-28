package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class RCV_Home_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Product> list_products, hint_products;
    public RCV_Home_Adapter(Context context) {
        this.context = context;
    }
    List<Integer> listImg;

    final int XML = 0;
    final int HOTPRODUCT = 1;
    final int CATE_PRODUCT = 2;
    final int HINT = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case XML:
                v = LayoutInflater.from(context).inflate(R.layout.home_xemmualien, parent, false);
                return new XML_Holder(v);
            case HOTPRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_hot_product, parent, false);
                return new HotProduct_Holder(v);
            case CATE_PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_home_cate_product, parent, false);
                return new CateProduct_Holder(v);
            case HINT:
                v = LayoutInflater.from(context).inflate(R.layout.home_product_hint, parent, false);
                return new HintProduct_Holder(v);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position){
            case 0:
                return XML;
            case 1:
                return HOTPRODUCT;
            case 2:
                return CATE_PRODUCT;
            case 3:
                return HINT;
        }
        return -1;

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LoadData();
        if (holder instanceof XML_Holder){

        }else if (holder instanceof HotProduct_Holder){
            RCV_HotProduct_Adapter rcv_hotProduct_adapter = new RCV_HotProduct_Adapter(context, list_products);
            ((HotProduct_Holder) holder).recyclerView_HotProduct.setLayoutManager(new GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false));
            ((HotProduct_Holder) holder).recyclerView_HotProduct.setAdapter(rcv_hotProduct_adapter);
        }else if (holder instanceof CateProduct_Holder){
            ((CateProduct_Holder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((CateProduct_Holder) holder).recyclerView.setAdapter(new RCV_HomeCateProduct_Adapter(context, list_products));
        } else if (holder instanceof HintProduct_Holder){
            ((HintProduct_Holder) holder).rcv.setLayoutManager(new GridLayoutManager(context, 2, RecyclerView.VERTICAL, false));
            ((HintProduct_Holder) holder).rcv.setAdapter(new RCV_HomeHintProduct_Adapter(context, hint_products));
        }
    }

    private void LoadData(){
        list_products = new ArrayList<>();
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        list_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        list_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        list_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        list_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        list_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        list_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        list_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        list_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        list_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        list_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));

        hint_products = new ArrayList<>();
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));

    }

    public class XML_Holder extends RecyclerView.ViewHolder {
        public XML_Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class HotProduct_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView_HotProduct;
        public HotProduct_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView_HotProduct = itemView.findViewById(R.id.rcv_hot_product);
        }
    }

    public class CateProduct_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public CateProduct_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_product);
        }
    }

    public class HintProduct_Holder extends RecyclerView.ViewHolder{
        RecyclerView rcv;
        public HintProduct_Holder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv);
        }
    }

}
