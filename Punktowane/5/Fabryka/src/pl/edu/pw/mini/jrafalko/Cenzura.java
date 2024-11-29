package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.annotations.*;
import pl.edu.pw.mini.jrafalko.censor.Censorable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**jr
 * 1 - 5 - 1p
 * 6,7 - 1.5p
 * 1p - za jakość
 * */
public class Cenzura implements Censorable {
    @Override
    public List<Pracownik> cenzuruj(List<Pracownik> list) {

        List<Pracownik> removeList = new ArrayList<Pracownik>();
        for (Pracownik pracownik : list) {
            Class<?> clazz = pracownik.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();

            // 1
            if (clazz.isAnnotationPresent(StringsToNull.class)) {
                while (clazz != null) {
                    Field[] fields2 = clazz.getDeclaredFields();
                    for (Field field : fields2) {
                        field.setAccessible(true);
                        if (field.getType() == String.class) {
                            try {
                                field.set(pracownik, "");
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    clazz = clazz.getSuperclass();
                }
            }
            clazz = pracownik.getClass();


            // 2
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(LeaveFirst3Characters.class)) {
                    if (field.getType() == String.class) {
                        try {
                            String string = (String) field.get(pracownik);
                            if (string != null && string.length() >= 3) {
                                String newString = string.substring(0, 3) + "___";
                                field.set(pracownik, newString);
                            } else if (string != null) {
                                field.set(pracownik, string + "___");
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }


            // 3
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == String.class && field.isAnnotationPresent(ReplaceString.class)) {
                    ReplaceString replaceString = field.getDeclaredAnnotation(ReplaceString.class);
                    String newString = replaceString.newString();
                    try {
                        field.set(pracownik, newString);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


            // 4
//            while (clazz != null) {
//                Field[] fields3 = clazz.getDeclaredFields();
//                for (Field field : fields3) {
//                    field.setAccessible(true);
//                    if (field.isAnnotationPresent(IntTo0.class) && field.getType() == int.class) {
//                        try {
//                            field.set(pracownik, 0);
//                        } catch (IllegalAccessException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//                clazz = clazz.getSuperclass();
//            }
//            clazz = pracownik.getClass();
            try {
                boolean present = false;
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(IntTo0.class) && field.getType() == int.class) {
                        field.set(pracownik, 0);
                        present = true;
                    }
                }
                if (!present) {
                    Field[] fields1 = clazz.getSuperclass().getDeclaredFields();
                    for (Field field : fields1) {
                        field.setAccessible(true);
                        if (field.isAnnotationPresent(IntTo0.class) && field.getType() == int.class) {
                            field.set(pracownik, 0);
                            present = true;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


            // 5
            for (Method method : methods) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(InvokeMethod.class)) {
                    int times = method.getDeclaredAnnotation(InvokeMethod.class).times();
                    for (int i = 0; i < times; i++) {
                        try {
                            method.invoke(pracownik);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }


            // 6
            if (clazz.isAnnotationPresent(RemoveBombs.class)) {
                ParameterType parameter = clazz.getDeclaredAnnotation(RemoveBombs.class).parameter();
                if (parameter == ParameterType.PRODUKTY) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getType() == Produkty.class) {
                            try {
                                field.set(pracownik, Produkty.BOMBKI);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                if (parameter == ParameterType.LICZBA) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getType() == int.class) {
                            try {
                                field.set(pracownik, -1);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }


            // 7
            if (clazz.isAnnotationPresent(DeleteYoung.class)) {
                try {
                    Field ageField = clazz.getSuperclass().getDeclaredField("wiek");
                    int age = (int) ageField.get(pracownik);
                    if (age < 30) {
                        removeList.add(pracownik);
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        list.removeAll(removeList);

        return list;
    }
}

