package com.example._04_ecommerce.Service;

import com.example._04_ecommerce.Utility.CommerceProduct;
import com.example._04_ecommerce.Utility.CommerceUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommerceService {

    private List<CommerceUser> users =  new ArrayList<>();
    private List<CommerceProduct> products =  new ArrayList<>();


}
