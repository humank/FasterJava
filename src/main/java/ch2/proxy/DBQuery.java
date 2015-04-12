package ch2.proxy;

/**
 * Created by yikai on 2015/4/12.
 */

/**
 * 若要強制所有的外部client access 都只能用 proxy ..<br/>
 * 那就把真實服務的class 都設定成 implicit-protected ( no access modifier class)
 */
class DBQuery implements IDBQuery {

    public DBQuery() {

        try {

            Thread.sleep(1000);

        } catch (InterruptedException iex) {

            iex.printStackTrace();
        }
    }

    @Override
    public String request() {

        return "query string !!! ";

    }
}
