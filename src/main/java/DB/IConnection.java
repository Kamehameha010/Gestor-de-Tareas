package DB;



public interface IConnection<T>{

    T connect();
    
    void close();
}
