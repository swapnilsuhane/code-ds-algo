package work;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Work {
    static List<String> na;

    static {
        na = Arrays.asList("shipping_type",
            "cast",
            "shipping_amount",
            "payable_shipping_fee",
            "payable_shipping_surcharge",
            "fk_sales_order_item_return_policy",
            "fk_sales_order_item_delivery_type",
            "store_credit_discount_on_item",
            "alipay_refund_coupon_amount",
            "alipay_promotion_coupon_amount");
    }

    public static void main(String[] args) throws Exception{
        Path path = Paths.get(System.getProperty("user.home")+"/tmp/daraz.txt");
        System.out.println(path.toString());

        System.out.println(na);

        if(Files.exists(path)){
            System.out.println("exists");
            List<String>  data = Files.readAllLines(path);
            //data.stream().map(d -> na.contains(d.substring(2, d.indexOf("as"))))
            data.stream().forEach(d -> {
                //System.out.println(" ->> " + d + " - " + d.indexOf(" as"));
                String str1  = d.substring(1, d.indexOf(" as"));
                String str2  = d.substring(d.indexOf(" as"));
                //System.out.println(" -> " + str1 + " - " + str2);
                if(na.contains(str1.trim())){
                    System.out.println("--" + d + "     *** NA in daraz ***");
                    System.out.println(",NULL                                 " + str2);
                }else {
                    System.out.println(d);
                }
            });
        }

    }

}
