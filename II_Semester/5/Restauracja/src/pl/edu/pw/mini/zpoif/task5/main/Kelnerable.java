package pl.edu.pw.mini.zpoif.task5.main;

import java.lang.reflect.InvocationTargetException;

public interface Kelnerable {
    void przyjmijZlecenie(Zamowienie zamowienie) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException;
}
