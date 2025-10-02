package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.cargo.BagOfPotatoes;
import pl.edu.pw.mini.jrafalko.cargo.Barrel;
import pl.edu.pw.mini.jrafalko.cargo.Cargo;
import pl.edu.pw.mini.jrafalko.cargo.Chest;
import pl.edu.pw.mini.jrafalko.truck.SpareWheel;
import pl.edu.pw.mini.jrafalko.truck.TireCompany;
import pl.edu.pw.mini.jrafalko.truck.Truck;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Random random = new Random();

        // task 1
        Class<?> barrelClass = Barrel.class;
        Constructor<?>[] barrelConstructors = barrelClass.getDeclaredConstructors();

        System.out.println("Zadanie 1\nLista konstruktorów:");

        for (Constructor<?> constructor : barrelConstructors) {
            constructor.setAccessible(true);
            Parameter[] parameters = constructor.getParameters();
            System.out.print("- " + constructor.getDeclaringClass().getSimpleName() + "( ");
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getSimpleName() + " ");
            }
            System.out.println(")");
        }


        // task 2
        Class<?> chestClass = Chest.class;
        Constructor<?>[] chestConstructors = chestClass.getDeclaredConstructors();

        System.out.println("\nZadanie 2");

        Optional<Constructor<?>> matchingChestConstructor = Arrays.stream(chestConstructors)
                .filter(c -> {
                    c.setAccessible(true);
                    return (Modifier.isProtected(c.getModifiers()) &&
                            c.getParameterCount() == 2 &&
                            ((c.getParameterTypes()[0] == boolean.class &&
                            c.getParameterTypes()[1] == String.class) ||
                                    (c.getParameterTypes()[1] == boolean.class &&
                                    c.getParameterTypes()[0] == String.class)));
                })
                .findFirst();

        if (matchingChestConstructor.isEmpty()) {
            System.out.println("Nie ma takiego konstruktora");
        }
        else {
            System.out.println("Jest taki konstruktor");
        }


        // task 3
        System.out.println("\nZadanie 3");
        String cargoPackage = Cargo.class.getPackageName();
        System.out.println(cargoPackage);


        // task 4
        System.out.println("\nZadanie 4");
        Class<?> potatoesClass = BagOfPotatoes.class;
        Method[] potatoesMethods = potatoesClass.getDeclaredMethods();

        System.out.println("Lista metod:");

        Arrays.stream(potatoesMethods)
                .filter(m -> Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> {
                    System.out.print("- " + m.getName() + "( ");
                    Parameter[] parameters = m.getParameters();
                    for (Parameter parameter : parameters) {
                        System.out.print(parameter.getType().getSimpleName() + " ");
                    }
                    System.out.println(")");
                });


        // task 5
        System.out.println("\nZadanie 5");
        Class<?> wheelClass = SpareWheel.class;
        try {
            Field stickerField = wheelClass.getDeclaredField("sticker");
            stickerField.setAccessible(true);
            stickerField.set(null, "Samar-Trans sp. z o.o.");
            System.out.println(stickerField.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        // task 6
        System.out.println("\nZadanie 6");
        Class<?> barrelSuperclass = barrelClass.getSuperclass();
        System.out.println(barrelSuperclass.getSimpleName());


        // task 7
        System.out.println("\nZadanie 7\nInterfejsy:");
        Class<?> cargoClass = Cargo.class;

        Arrays.stream(cargoClass.getInterfaces()).forEach(i -> {
            if (i.getPackage().equals(cargoClass.getPackage())){
                System.out.println("- " + i.getSimpleName() + " - ten sam pakiet");
            }
            else {
                System.out.println("- " + i.getSimpleName());
            }
            }
        );


        // task 8
        System.out.println("\nZadanie 8");
        Class<?> spareWheelClass = SpareWheel.class;
        Object spareWheel = spareWheelClass.getConstructor().newInstance();
        Field tireSizeField = spareWheelClass.getDeclaredField("tireSize");
        tireSizeField.setAccessible(true);
        String tireSize = (String) tireSizeField.get(spareWheel);
        System.out.println(tireSize);


        // task 9
        System.out.println("\nZadanie 9");
        ArrayList<Cargo> cargoList = new ArrayList<>();

        cargoList.addAll(Arrays.stream(barrelConstructors)
                .map(c -> {
                    c.setAccessible(true);
                    try {
                        Class<?>[] parameterTypes = c.getParameterTypes();
                        Object[] parameters = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (parameterTypes[i] == boolean.class) {
                                parameters[i] = random.nextBoolean();
                            } else if (parameterTypes[i] == int.class) {
                                parameters[i] = 100;
                            } else {
                                parameters[i] = parameterTypes[i].getConstructor().newInstance();
                            }
                        }
                        return (Cargo) c.newInstance(parameters);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList());

        cargoList.addAll(Arrays.stream(chestConstructors)
                .map(c -> {
                    c.setAccessible(true);
                    try {
                        Class<?>[] parameterTypes = c.getParameterTypes();
                        Object[] parameters = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (parameterTypes[i] == boolean.class) {
                                parameters[i] = random.nextBoolean();
                            } else if (parameterTypes[i] == int.class) {
                                parameters[i] = 100;
                            } else {
                                parameters[i] = parameterTypes[i].getConstructor().newInstance();
                            }
                        }
                        return (Cargo) c.newInstance(parameters);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList());

        cargoList.addAll(Arrays.stream(potatoesClass.getDeclaredConstructors())
                .map(c -> {
                    c.setAccessible(true);
                    try {
                        Class<?>[] parameterTypes = c.getParameterTypes();
                        Object[] parameters = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (parameterTypes[i] == boolean.class) {
                                parameters[i] = random.nextBoolean();
                            } else if (parameterTypes[i] == int.class) {
                                parameters[i] = 100;
                            } else {
                                parameters[i] = parameterTypes[i].getConstructor().newInstance();
                            }
                        }
                        return (Cargo) c.newInstance(parameters);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList());

        System.out.println("Stworzono kolekcję:");
        for (Cargo cargo : cargoList) {
            System.out.println(cargo);
        }


        // task 10
        System.out.println("\nZadanie 10");
        Class<?> truckClass = Truck.class;
        Truck truck = (Truck) truckClass.getConstructor().newInstance();
        System.out.println("Stworzono ciężarówkę");


        // task 11
        System.out.println("\nZadanie 11");
        try {
            Field loadingBodyField = truckClass.getDeclaredField("loadingBody");
            loadingBodyField.setAccessible(true);
            Object loadingBodyObj = loadingBodyField.get(truck);
            Method addCargoMethod = loadingBodyObj.getClass().getDeclaredMethod("addCargo", Cargo.class);
            addCargoMethod.setAccessible(true);
            for (Cargo cargo : cargoList) {
                addCargoMethod.invoke(loadingBodyObj, cargo);
            }
            System.out.println("Dodano towary");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


        // task 12
        System.out.println("\nZadanie 12");
        Field spareWheelField = truckClass.getDeclaredField("spareWeel");
        spareWheelField.setAccessible(true);
        spareWheelField.set(truck, spareWheel);

        Field fuelTankField = truckClass.getDeclaredField("fuelTank");
        fuelTankField.setAccessible(true);
        Class<?> fuelTankClass = fuelTankField.getType();
        Object fuelTank = fuelTankClass.getConstructor(truckClass, boolean.class).newInstance(truck, true);
        fuelTankField.set(truck, fuelTank);

        System.out.println("Ustawiono pola");


        // task 13
        System.out.println("\nZadanie 13");
        Field driversCabinField = truckClass.getDeclaredField("driversCabin");
        driversCabinField.setAccessible(true);

        if (driversCabinField.get(truck) == null) {
            Class<?> driversCabinClass = driversCabinField.getType();
            Object driversCabin = driversCabinClass.getConstructor().newInstance();

            driversCabinField.set(truck, driversCabin);
        }
        System.out.println("Ustawiono kierowcę");

        // task 14
        System.out.println("\nZadanie 14");
        Object driversCabin = driversCabinField.get(truck);
        Field driverField = driversCabin.getClass().getDeclaredField("driver");
        driverField.setAccessible(true);

        Object driver = driverField.get(driversCabin);
        Method drive = driver.getClass().getDeclaredMethod("drive");
        drive.setAccessible(true);

        drive.invoke(driver);


        // task 15
        // adnotacje???
        System.out.println("\nZadanie 15");
        if (wheelClass.isAnnotationPresent(TireCompany.class)) {
            TireCompany tireCompany = wheelClass.getAnnotation(TireCompany.class);
            System.out.println("Nazwa producenta: " + tireCompany.sticker());
            System.out.println("Rozmiar opony: " + tireCompany.tireSize());
        }


    }

    /**
     1.	Wypisz listę konstruktorów wraz z parametrami klasy Barrel
        korzystając z informacji możliwych do uzyskania z obiektu klasy.
     2.	Ustal, czy klasa Chest posiada konstruktor o modyfikatorze protected,
        przyjmujący dwa parametry: boolean i String. Odpowiedź wypisz w konsoli.
     3.	Uzyskaj informacje o nazwie pakietu klasy Cargo. Wypisz w konsoli.
     4.	Wylistuj prywatne metody klasy BagOfPotatoes wraz z parametrami.
     5.	Ustal (pobierz) wartość pola sticker znajdującego się w klasie KoloOdCiezarowki i wypisz na konsoli.
     6.	Wypisz nazwę nadklasy klasy Barrel.
     7.	Wylistuj interfejsy implementowane przez klasę Cargo. Sprawdź,
        czy któryś z nich pochodzi z tego samego pakietu, co ta klasa.
     8.	Stwórz obiekt klasy KoloOdCiezarowki i sprawdź wartość pola tireSize na tym obiekcie.
     9.	Utwórz kolekcję beczek, skrzyń i worków z ziemniakami używając
        każdego z konstruktorów w tych klasach.
     10.Utwórz obiekt klasy Truck.
     11.Uzyskaj dostęp do pola loadingBody w utworzonym wcześniej obiekcie i wywołaj na nim
        metodę addCargo, dodając obiekty utworzone w punkcie 9-tym.
     12.Przypisz polom (instancji klasy Truck) spareWeel i fuelTank instancje stworzonych
        obiektów klas SpareWeel i FuelTank(napełniony). Informację o typach zaczerpnij z klas tych pól.
     13.Uzyskaj dostęp do pola: driversCabin i sprawdź czy elementy tego pola mają wartość null.
        Jeśli tak, to wstaw tam utworzone obiekty odpowiedniego typu.
        Informację o typach zaczerpnij z klas tych pól.
     14.Wywołaj metodę drive zdefiniowaną dla kierowcy.
     15.Stwórz adnotację TireCompany działającą podczas wykonania programu zawierającą dwie
        informacje będące ciągami znaków: nazwa producenta oraz rozmiar opony.
        "Ozdób" nią klasę spareWeel. Wstaw dowolne wartości.
     */

}
