import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by pkura on 2016-03-10.
 */
public class Throwable1 {
    public static void main(String[] args) {
        // When (Catchable)
        //  -> Write
    //            db
    //            file
    //            jcr
    //            solr
//        fileM();
        dbM2();
        nothingM();
        jcrM();
        dbM();

    }

    private static void nothingM() {
        try{
            // lupka()
            throw new Exception("debian another then windows/suse file system to write file!!!");
        }catch (Throwable t){}
    }

    private static void jcrM() {
        // We exactly know what to do, but only write logs
        try{
            // getAttachmentJcr()
            throw new Exception();
        }catch (Throwable t){
            //write to log
            System.out.println("Persistent storage from where: jcr not connected");
        }
    }

    private static void fileM() {
        // We exactly know what to do
        File f = new File("");
        try{
            //write to file => needed permission => IOException
            f.delete();
            methodThrowingRuntimeEx();
          //  throw new Throwable("External resorce file");
        }catch (Throwable t){
            //write to /my/localization/file
            System.out.println("Persistent storage from where: " + t.getMessage());
        }finally {
            System.out.println("Try egen delete file, with another permission");
            f.delete();
        }
    }

    private static void dbM() throws Error {
        // We donot know what to do -> throw unchecked exception
        try{
            //conect to db
            throw new DBException("Sql error");

        }catch (DBException db){
//          AddToAction("Sql error");
//          throw new RuntimeException("Cant recover resource == " + db.getMessage());
            throw new Error("Connection to DB is broken == " + db.getMessage());
        }finally {
            System.out.println("Try egen delete file, with another permission");
            //close
        }
    }

    private static void dbM1() {
        // We exactly know what to do
        try{
            Transaction.create();
            // Create Higher order function for like method around pattern
            // Strategy, One way to perform transaction => Consistent
            throw new SQLException("Sql error");
        }catch (SQLException db){
            Transaction.rollback();
//          log.acction
        }finally {
            Transaction.close();
        }
    }

    private static void dbM2() {
        // We exactly know what to do
        try{
            // openSession()
            new Callable<List>() {
                public List getAllUser() {
                    return null;
                }

                @Override
                public List call() throws Exception {
                    return getAllUser();
                }
            };
            // Create Higher order function for like method around pattern
            // Strategy, One way to perform session context hibernate => Consistent
            throw new SQLException("Sql error");
        }catch (SQLException db){
            // closeSession()
            System.out.println("clean session");
//          log.acction
        }finally {
            // closeSession()
            System.out.println("close session");
        }
    }

    private static void methodThrowingRuntimeEx() {
        throw new NullPointerException();
    }
}
