package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MySolution extends Solution{
    @Override
    public Object task1() {
        try {
            Class<?> classWygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Object wygodnaBudka = classWygodnaBudka.getDeclaredConstructor().newInstance();
            return wygodnaBudka;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void task2(Object wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        try {
            Field bazgrol = classWygodnaBudka.getDeclaredField("bazgrol");
            bazgrol.setAccessible(true);
            System.out.println(bazgrol.get(wygodnaBudka));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task3(Object wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        Class<?> classBudka = classWygodnaBudka.getSuperclass();
        try {
            Field uniwersalmySzyfrField = classBudka.getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
            uniwersalmySzyfrField.setAccessible(true);
            String uniwersalnySzyfr = (String)uniwersalmySzyfrField.get(wygodnaBudka);
            Field szyfrField = classWygodnaBudka.getDeclaredField("szyfrDoSejfu");
            szyfrField.setAccessible(true);
            szyfrField.set(wygodnaBudka, uniwersalnySzyfr);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task4(WygodnaBudka wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        Method[] methods = classWygodnaBudka.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getReturnType() == Integer.class && method.getParameterCount() == 0) {
                method.setAccessible(true);
                try {
                    Integer result = (Integer) method.invoke(wygodnaBudka);
                    System.out.println("Metoda: " + method.getName());
                    System.out.println("Wynik: " + result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void task5() {
        try {
            Class<?> wygodnaBudkaClass = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Field dobreWyrkoField = wygodnaBudkaClass.getDeclaredField("dobreWyrko");
            dobreWyrkoField.setAccessible(true);
            Class<?> dobreWyrkoClass = dobreWyrkoField.get(null).getClass();
            System.out.println("Hierarchia klas dla: " + dobreWyrkoField.getName());
            while(dobreWyrkoClass != null) {
                System.out.println(dobreWyrkoClass.getSimpleName());
                dobreWyrkoClass = dobreWyrkoClass.getSuperclass();
            }
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object task6() {
        try {
            Class<?> wygodneWyrkoClass = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Constructor<?> constructor = wygodneWyrkoClass.getConstructor(String.class, String.class);
            constructor.setAccessible(true);
            Object wygodnaBudka = constructor.newInstance("Super", "Dobre graty");
            return wygodnaBudka;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task7(WygodnaBudka wygodnaBudka) {
        Class<?> wygodnaBudkaClass = wygodnaBudka.getClass();
        try {
            Field sejfField = wygodnaBudkaClass.getDeclaredField("sejf");
            sejfField.setAccessible(true);

            Object sejf = sejfField.get(wygodnaBudka);
            Class<?> sejfClass = sejf.getClass();
            Method openMethod = sejfClass.getMethod("open", String.class);

            Field szyfrDoSejfuField = wygodnaBudkaClass.getDeclaredField("szyfrDoSejfu");
            szyfrDoSejfuField.setAccessible(true);
            String szyfr = (String) szyfrDoSejfuField.get(wygodnaBudka);

            openMethod.invoke(sejf, szyfr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task8() {
        try {
            Class<?> wygodnaBudkaClass = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Class<?> nadklasa = wygodnaBudkaClass.getSuperclass();
            Class<?>[] klasyWewnetrzne = nadklasa.getDeclaredClasses();
            for (Class<?> klasa : klasyWewnetrzne) {
                int zasieg = klasa.getModifiers();
                if (Modifier.isProtected(zasieg)) {
                    System.out.println(klasa.getSimpleName());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int task9(WygodnaBudka wygodnaBudka) {
        Class<?> wygodnaBudkaClass = wygodnaBudka.getClass();
        Class<?> nadklasa = wygodnaBudkaClass.getSuperclass();

        Field[] nadklasaFields = Arrays.stream(nadklasa.getDeclaredFields())
                .filter(field -> field.getType() == Integer.class). toArray(Field[]::new);
        Field[] wygodnaBudkaFields = Arrays.stream(wygodnaBudkaClass.getDeclaredFields())
                .filter(field -> field.getType() == Integer.class). toArray(Field[]::new);

        int suma = 0;
        try {
            for (Field field : nadklasaFields) {
                field.setAccessible(true);
                suma += (Integer) field.get(wygodnaBudka);
            }
            for (Field field : wygodnaBudkaFields) {
                field.setAccessible(true);
                suma -= (Integer) field.get(wygodnaBudka);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return suma;
    }

}
