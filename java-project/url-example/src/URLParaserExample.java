import java.io.IOException;

/**
 * Created on 2019-07-30.
 *
 * @author 迹_Jason
 */
public class URLParaserExample {

    public static void main(String[] args) throws IOException {
        test4();
    }

    /**
     * 获取URL指定的资源。
     *
     * @throws IOException
     */
    public static void test4() throws IOException {
        System.out.println(UrlPage("http://10.20.23.34:8080/p_w_upload/200811/200811271227767778082#sdsd"));
        System.out.println(UrlPage("https://mofang.tfabric.com/?code=0014RHXC1JThU407JbYC1Cc0YC14RHXy&state=STATE"));
        System.out.println(UrlPage("https://mofang.tfabric.com/#/"));
        System.out.println(UrlPage("https://mofang.tfabric.com/index.html"));
        System.out.println(UrlPage("https://mofang.tfabric.com/index"));
        System.out.println(UrlPage("app://CGMyIncomeViewController"));
        System.out.println(UrlPage("https://h5.360fengdai.com/#/creditSuper"));
        System.out.println(UrlPage("https://h5.360fengdai.com/#/creditSuper#user"));

    }

    public static String UrlPage(String strURL) {
        String strPage = null;
        String[] arrSplit;

        strURL = strURL.trim().toLowerCase();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 0) {
            if (arrSplit.length > 1) {
                if (arrSplit[0] != null) {
                    strPage = arrSplit[0];
                }
            } else {
                return arrSplit[0];
            }
        }

        return strPage;
    }
}
