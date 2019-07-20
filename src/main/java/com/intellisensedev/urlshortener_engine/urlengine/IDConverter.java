package com.intellisensedev.urlshortener_engine.urlengine;

import java.util.*;

public class IDConverter {


    /**
     * takes in an id (base10) and converts it into base62
     * example if id=125
     *      125 / 64 =  2 remainder 1
     *      2 / 64 =    0 remainder 2
     *
     *      return [2,1]
     */
    public void convertIdToBase64(int id){

        List<Integer> list = new ArrayList<>();
        int idToBase64 = 0;

        while (id > 0){
            //find the quotient
            id = id / 64;

            //store the remainter
            int remainder = id % 64;
            list.add(remainder);

            /**
             * collect remainder from bottom to top
             * and return list
             */
            for (int i = list.size(); i-- > 0; ){
                idToBase64 = list.get(i);
            }
        }

        System.out.println("short.com/"+ encode(Collections.singletonList(idToBase64)));
    }


    public String encode(List<Integer> list){

        //check list against base64String
        String base64String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "";
        for(int i = 0; i <= list.size(); i++){

            shortUrl += base64String.indexOf(i);
        }
        return shortUrl;
    }



}
