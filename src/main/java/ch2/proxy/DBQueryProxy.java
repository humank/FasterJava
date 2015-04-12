package ch2.proxy;

/**
 * Created by yikai on 2015/4/12.
 */

/**
 * 這是屬於靜態代理的做法!!
 *
 */
public class DBQueryProxy implements IDBQuery {

    private IDBQuery real;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQuery();
        }
        //在多執行緒環境下，傳回一個虛假類別類似Future pattern
        return real.request();
    }
}
