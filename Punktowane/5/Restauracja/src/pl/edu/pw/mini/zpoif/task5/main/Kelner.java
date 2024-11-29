package pl.edu.pw.mini.zpoif.task5.main;

import pl.edu.pw.mini.zpoif.task5.model.ObiektGastronomiczny;
import pl.edu.pw.mini.zpoif.task5.model.Pracownik;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Random;

public class Kelner extends ObiektGastronomiczny implements Kelnerable {

    private ArrayList<Object> pracownicy;
    Random random = new Random();

    public Kelner() {
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik){
        pracownicy.add(pracownik);
    }

    @Override
    public void przyjmijZlecenie(Zamowienie zamowienie) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> adnotacja = Class.forName(zamowienie.getNazwaKlasy());
        for (Object pracownik : pracownicy) {
            Class<?> klasa = pracownik.getClass();
            Method[] methods = klasa.getDeclaredMethods();
            if (klasa.isAnnotationPresent((Class<? extends Annotation>) adnotacja)) {
                int i = random.nextInt(methods.length);
                methods[i].invoke(pracownik);
                return;
            }
            ArrayList<Method> methodsWithAnnotation = new ArrayList<>();
            for (Method method : methods) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) adnotacja)) {
                    methodsWithAnnotation.add(method);
                }
            }
            if (!methodsWithAnnotation.isEmpty()) {
                int i = random.nextInt(methodsWithAnnotation.size());
                Method method = methodsWithAnnotation.get(i);
                if (method.getParameterCount()>0){
                    if (method.getParameterCount()==1 && method.getParameterTypes()[0] == String.class) {
                        String powod = "Wyrzucam cie bo tak";
                        method.invoke(pracownik, powod);
                    }
                }
                else {
                    method.invoke(pracownik);
                }
                return;
            }

        }
        System.out.println("Dania nie będzie!");
    }
}

