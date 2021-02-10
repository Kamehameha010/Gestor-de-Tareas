package execute;

import javax.swing.Icon;

public class App {

    public static void main(String[] args) {

        System.out.println("HEllo");
    }

}

interface IConn {
    void connect();
    void close();
}


class ConnectionMongo implements IConn{


    @Override
    public void connect() {
        System.out.println("conectado MongoDB");

    }

    @Override
    public void close() {
        System.out.println("desconectado MongoDB");

    }

}

interface IConnectionSql extends IConn{
    void ExecuteQuery();
}

class ConnectionMySQL implements IConnectionSql{

    private String connection;
    @Override
    public void connect() {
        System.out.println("conectado mysql");
    }

    @Override
    public void close() {
        System.out.println("desconectado mysql");
    }

    @Override
    public void ExecuteQuery() {
        System.out.println("Pasa query");    
    }
}
interface ICRUD{
    void create();
    void read();
    void update();
    void delete();
}

class PersonMongo implements ICRUD{

    @Override
    public void create() {
        // TODO Auto-generated method stub

    }

    @Override
    public void read() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub

    }

}

class PersonMysql implements ICRUD{

    @Override
    public void create() {
        System.out.println("Methodo create");

    }

    @Override
    public void read() {
        System.out.println("Methodo read");

    }

    @Override
    public void update() {
        System.out.println("Methodo update");

    }

    @Override
    public void delete() {
        System.out.println("Methodo delete");

    }

}


class PersonController{
    private IConnectionSql conn;

    public PersonController(IConnectionSql conn){
        this.conn = conn;
    }

    public void insert(){
        conn.ExecuteQuery();
    }
}