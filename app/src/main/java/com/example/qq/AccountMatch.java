package com.example.qq;

import android.nfc.Tag;
import android.util.Log;

import org.litepal.crud.DataSupport;
import java.util.List;

public class AccountMatch {
    static String temp_Password;

    //传入id, 若存在id则返回true, 否则返回false
    public static boolean isThereAccount(String id) {
        List<AccountData> ads = DataSupport.select("accountId").where("accountId == ?", id).find(AccountData.class);
        try{
            if(ads.get(0) != null) return true;
        }
        catch(Exception e){
        }
        return false;
    }

    public  static  boolean isPasswordRight(String id, String password){
        List<AccountData> ads = DataSupport.select("accountPassword").where("accountId == ?", id).find(AccountData.class);
        for(AccountData ad:ads){
            temp_Password = ad.getAccountPassword();
        }
        if(password.equals(temp_Password)){
            return true;
        }
        return false;
    }
}
