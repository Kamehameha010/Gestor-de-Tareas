package com.cr.DB;



public interface IConnection<T>{

    T connect();
    
    void close();
}
